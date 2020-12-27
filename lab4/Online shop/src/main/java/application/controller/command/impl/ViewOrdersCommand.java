package application.controller.command.impl;

import application.controller.util.Pagination;
import application.controller.util.constants.Pages;
import application.domain.Order;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;
import application.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewOrdersCommand extends AbstractCommand {
    private OrderService service;

    public ViewOrdersCommand() {
        this.service = new OrderService();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> orders = service.getAllOrders();
            new Pagination().configure(request, 3, "orders", orders);
        } catch (NoOrderException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        }
        return Pages.EDIT_ORDER_STATUS;
    }
}
