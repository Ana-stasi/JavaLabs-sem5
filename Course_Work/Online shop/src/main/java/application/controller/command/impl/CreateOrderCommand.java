package application.controller.command.impl;

import application.controller.command.AbstractCommand;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Order;
import application.domain.Product;
import application.domain.User;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;
import application.model.service.OrderService;
import application.model.service.ProductService;
import application.model.service.UserService;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CreateOrderCommand extends AbstractCommand {
    private OrderService service;
    final static Logger logger = Logger.getLogger(CreateOrderCommand.class);

    public CreateOrderCommand() {
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String createResult = "";
        try {
            createResult = createOrder(request);
            logger.info(request.getSession().getAttribute("username")+"successfully created order");
        } catch (NoSuchProductException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Servlets.CREATE_ORDER);
            logger.error(request.getSession().getAttribute("username")+" tried to order nonexistent product");
        } catch (MySQLException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Pages.START_PAGE);
            logger.fatal("System error, caused by problems with database");
        }
        request.setAttribute("success", getMessage(request,createResult));
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private String createOrder(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        HttpSession session = req.getSession(true);
        User user = new UserService().findByName((String) session.getAttribute("username"));
        UUID orderId = UUID.randomUUID();
        service.addOrder(new Order(orderId, user.getId()));
        double totalCost = getTotalCost(req);
        if (totalCost == 0) {
            service.deleteOrder(new Order(orderId, user.getId(), totalCost));
        }
        return service.addOrder(new Order(orderId, user.getId(), totalCost));
    }

    private double getTotalCost(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        double price = getProduct(req).getPrice();
        int amount = Integer.parseInt(req.getParameter("amount"));
        return price * amount;
    }

    private Product getProduct(HttpServletRequest req) throws NoSuchProductException, MySQLException {
        int productId = Integer.parseInt(req.getParameter("product_id"));
        return new ProductService().findProduct(productId);
    }
}
