package application.controller.command.impl;

import application.controller.util.Validator;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.model.dto.ProductDTO;
import application.model.exception.MySQLException;
import application.model.exception.WrongInputException;
import application.model.service.ProductService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddProductCommand extends AbstractCommand {
    private ProductService service;

    public AddProductCommand() {
        this.service = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addResult = "";
        try {
            ProductDTO product = getProduct(request);
            addResult = service.addProduct(product);
        } catch (WrongInputException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.ADD_ORDER);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        }
        request.setAttribute("success", addResult);
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private ProductDTO getProduct(HttpServletRequest req) throws WrongInputException {
        ProductDTO product = null;
        Validator.checkDouble(req.getParameter("price"), "price");
        Validator.checkDouble(req.getParameter("weight"), "weight");
        int category = getCategory(req);
        String name = req.getParameter("pr_name");
        double price = Double.parseDouble(req.getParameter("price"));
        int color = getColor(req);
        double weight = Double.parseDouble(req.getParameter("weight"));
        product = new ProductDTO(category, name, price, color, weight);
        return product;
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
