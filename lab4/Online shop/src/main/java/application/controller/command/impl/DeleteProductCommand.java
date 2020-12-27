package application.controller.command.impl;

import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Product;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;
import application.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteProductCommand extends AbstractCommand {
    private ProductService service;

    public DeleteProductCommand() {
        this.service = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delResult = "";
        try {
            Product product = getProduct(request);
            delResult = service.deleteProduct(product.getId());
        } catch (NoSuchProductException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.DELETE_PRODUCT);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        }
        request.setAttribute("success", delResult);
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private Product getProduct(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        int productId = Integer.parseInt(req.getParameter("product_id"));
        return service.findProduct(productId);
    }

}
