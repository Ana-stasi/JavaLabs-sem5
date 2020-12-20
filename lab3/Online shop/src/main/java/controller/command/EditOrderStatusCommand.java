package lab3.controller.command;

import lab3.model.entity.Order;
import lab3.model.service.OrderService;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.model.service.exceptions.NoOrderException;
import lab3.view.page.PageView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EditOrderStatusCommand extends FrontCommand{
private OrderService service;
    public EditOrderStatusCommand(PageView view) {
        super(view);
        this.service = new OrderService();
    }

    @Override
    public void execute() {
        try {
            Order order = getOrder();
            int orderStatus = view.getOrderStatus();
            order.setStatusId(orderStatus);
            view.printMessage(service.updateOrder(order));
        }catch (NoOrderException e){
            view.printMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private Map<Integer,Order> printOrders(){
        Map<Integer, Order> orders = new HashMap<>();
        try {
            orders = service.getAllOrders();
            view.printMessage("№\t"+view.orderColumns);
            orders.forEach((key, value)-> view.printMessage(key+"\t"+value));
        } catch (EmptyCatalogueException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
return orders;
    }

    private Order getOrder(){
        Map<Integer,Order> orders =printOrders();
        Integer orderNumber = view.getIntValue("Type order №:");
        if(orders.containsKey(orderNumber)) return orders.get(orderNumber);
        else throw new NoOrderException("Order with such № doesn`t exist");
    }

}
