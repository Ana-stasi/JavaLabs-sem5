package application.controller.command.impl;

import application.controller.command.AbstractCommand;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Product;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;
import application.model.service.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductCommand extends AbstractCommand {
    private ProductService service;
    final static Logger logger = Logger.getLogger(DeleteProductCommand.class);

    public DeleteProductCommand() {
        this.service = new ProductService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delResult = "";
        try {
            Product product = getProduct(request);
            delResult = service.deleteProduct(product.getId());
            logger.info("Product №"+ product.getId()+" was deleted by"+request.getSession().getAttribute("username"));
        } catch (NoSuchProductException e) {
            setErrorRequest(request, response,getMessage(request,e.getMessage()), Servlets.DELETE_PRODUCT);
            logger.warn("Admin tried to delete nonexistent product");
        } catch (MySQLException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Pages.START_PAGE);
            logger.fatal("System error, caused by problems with database");
        }
        request.setAttribute("success", getMessage(request,delResult));
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private Product getProduct(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        int productId = Integer.parseInt(req.getParameter("product_id"));
        return service.findProduct(productId);
    }

}
