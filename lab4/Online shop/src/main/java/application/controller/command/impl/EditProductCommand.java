package application.controller.command.impl;

import application.controller.util.Validator;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Product;
import application.model.dto.ProductDTO;
import application.model.exception.EmptyCatalogueException;
import application.model.exception.InvalidTypeException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;
import application.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditProductCommand extends AbstractCommand {
    private ProductService service;

    public EditProductCommand() {
        service = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String editResult = "";
        try {
            Product product = getProduct(request);
            ProductDTO newProduct = editProduct(product.getId(), request);
            editResult = service.updateProduct(newProduct);
        } catch (NoSuchProductException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.EDIT_PRODUCT);
        } catch (MySQLException | InvalidTypeException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.LOGIN);
        }
        request.setAttribute("success", editResult);
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private ProductDTO editProduct(int productId, HttpServletRequest req) throws EmptyCatalogueException {
        ProductDTO product = null;
        Validator.checkDouble(req.getParameter("price"), "price");
        Validator.checkDouble(req.getParameter("weight"), "weight");
        int category = getCategory(req);
        String name = req.getParameter("pr_name");
        double price = Double.parseDouble(req.getParameter("price"));
        int color = getColor(req);
        double weight = Double.parseDouble(req.getParameter("weight"));
        product = new ProductDTO(productId, category, name, price, color, weight);
        return product;
    }

    private Product getProduct(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        int productId = Integer.parseInt(req.getParameter("product_id"));
        return service.findProduct(productId);
    }

    private int getColor(HttpServletRequest req) {
        int color = 3;
        String[] colors = req.getParameterValues("color");
        for (String c : colors) {
            if (!c.equals("Color")) color = Integer.parseInt(c);
        }
        return color;
    }

    private int getCategory(HttpServletRequest req) {
        int category = 3;
        String[] colors = req.getParameterValues("category");
        for (String c : colors) {
            if (!c.equals("Category")) category = Integer.parseInt(c);
        }
        return category;
    }
}
