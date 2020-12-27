package application.controller.command.impl;

import application.controller.util.Pagination;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Product;
import application.model.exception.EmptyCatalogueException;
import application.model.exception.MySQLException;
import application.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ShowCatalogueCommand extends AbstractCommand {
    private ProductService service;

    public ShowCatalogueCommand() {
        this.service = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = service.getProductList(getSortType(request));
            new Pagination().configure(request, 5, "products", products);
        } catch (EmptyCatalogueException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.VIEW_CATALOGUE);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        }
        return getHomepage(request);
    }


    private String getHomepage(HttpServletRequest req) {
        String role = (String) req.getSession(true).getAttribute("role");
        String homePage = Pages.GUEST_PAGE;
        if (role != null) {
            if (role.equals("admin")) homePage = Pages.ADMIN_HOMEPAGE;
            else if (role.equals("user")) homePage = Pages.USER_HOMEPAGE;
        }
        return homePage;
    }

}
