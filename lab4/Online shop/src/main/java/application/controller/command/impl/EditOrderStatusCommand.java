package application.controller.command.impl;


import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Order;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;
import application.model.exception.WrongInputException;
import application.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class EditOrderStatusCommand extends AbstractCommand {

    private OrderService service;

    public EditOrderStatusCommand() {
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateResult = "";
        try {
            Order order = getOrder(request);
            order.setStatus(getStatus(request));
            updateResult = service.updateOrder(order);
        } catch (NoOrderException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.ORDER_STATUS);
        } catch (MySQLException e) {
            setErrorRequest(request, response,e.getMessage(), Pages.START_PAGE);
        }
        request.setAttribute("success", updateResult);
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }


    private Order getOrder(HttpServletRequest req) throws NoOrderException, MySQLException {
        Order order = null;
        List<Order> orders = service.getAllOrders();
        int orderNumber = Integer.parseInt(req.getParameter("order_number"));
        for (Order o : orders) {
            if (o.getNumber() == orderNumber)
                order = o;
        }
        if (order == null) throw new NoOrderException("Order with such № doesn`t exist");
        return order;
    }

    private String getStatus(HttpServletRequest req) throws WrongInputException {

        String orderStatus = "registered";
        String[] statuses = req.getParameterValues("status");
        for (String s : statuses) {
            if (s.equals("paid")) orderStatus = s;
            else if (s.equals("canceled")) orderStatus = s;
        }
        return orderStatus;
    }


}
