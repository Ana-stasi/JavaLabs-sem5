package lab3.controller.command;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.model.entity.Order;
import lab3.model.entity.UserSession;
import lab3.model.service.OrderService;
import lab3.model.service.exceptions.NoOrderException;
import lab3.view.page.PageView;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ShowOrdersCommand extends FrontCommand {
    private OrderService service;

    public ShowOrdersCommand(PageView view) {
        super(view);
        this.service = new OrderService();
    }

    @Override
    public void execute() {
        try {
            UUID userId = UserSession.getUserSession().getUserId();
            List<Order> orders = service.getOrders(userId);
            view.printData(orders, view.orderColumns);
        } catch (InvalidTypeException | NoOrderException e) {
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }
}
