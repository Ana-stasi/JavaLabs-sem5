package application.controller.command.impl;


import application.controller.command.AbstractCommand;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.Order;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;
import application.model.exception.WrongInputException;
import application.model.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class EditOrderStatusCommand extends AbstractCommand {

    private OrderService service;
    final static Logger logger = Logger.getLogger(EditOrderStatusCommand.class);

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
            logger.info("Status of order № "+ order.getNumber()+" was changed to"+getStatus(request));
        } catch (NoOrderException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Servlets.ORDER_STATUS);
            logger.warn("Admin"+request.getSession().getAttribute("username")+" tried to edit status of nonexistent order");
        } catch (MySQLException e) {
            setErrorRequest(request, response,getMessage(request,e.getMessage()), Pages.START_PAGE);
            logger.fatal("System error, caused by problems with database");
        }
        request.setAttribute("success", getMessage(request,updateResult));
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
        if (order == null) throw new NoOrderException("label.no_order_exist");
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
