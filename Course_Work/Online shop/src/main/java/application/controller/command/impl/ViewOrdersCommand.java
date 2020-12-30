package application.controller.command.impl;

import application.controller.command.AbstractCommand;
import application.controller.util.Pagination;
import application.controller.util.constants.Pages;
import application.domain.Order;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;
import application.model.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewOrdersCommand extends AbstractCommand {
    private OrderService service;
    final static Logger logger = Logger.getLogger(ViewOrdersCommand.class);

    public ViewOrdersCommand() {
        this.service = new OrderService();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> orders = service.getAllOrders();
            new Pagination().configure(request, 3, "orders", orders);
        } catch (NoOrderException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Pages.START_PAGE);
        } catch (MySQLException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Pages.START_PAGE);
            logger.fatal("System error, caused by problems with database");
        }
        return Pages.EDIT_ORDER_STATUS;
    }
}
