package application.controller.command.impl;

import application.controller.command.AbstractCommand;
import application.controller.util.Pagination;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Order;
import application.domain.User;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;
import application.model.service.OrderService;
import application.model.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowOrdersCommand extends AbstractCommand {
    private OrderService service;
    final static Logger logger = Logger.getLogger(ShowOrdersCommand.class);

    public ShowOrdersCommand() {
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = (String) request.getSession(true).getAttribute("username");
            User user = new UserService().findByName(username);
            List<Order> orders = service.getOrders(user.getId());
            new Pagination().configure(request, 4, "orders", orders);
        } catch (NoOrderException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Servlets.VIEW_CATALOGUE);
        } catch (MySQLException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Pages.START_PAGE);
            logger.fatal("System error, caused by problems with database");
        }
        return Pages.VIEW_ORDERS;
    }

}
