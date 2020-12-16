package controller.command;

import exceptions.WrongMenuItemException;
import model.entity.Order;
import model.entity.OrderLine;
import model.entity.Product;
import model.entity.UserSession;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShowCatalogueCommand extends FrontCommand {
    BaseService<List<Product>,String> service ;
    public ShowCatalogueCommand(PageView view, String request) {
        super(view, request);
        service = serviceFactory.createService(request);
    }

    @Override
    public void execute() {

        view.showCatalogueSortMenu();
        String sortType = view.getSortType(5);
        try {
                view.printData(service.performAction(sortType), view.catalogueColumns);
        } catch (WrongMenuItemException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        if(UserSession.getUserSession().getRole().equals("user")){
                CreateOrder();
        }
    }

    private void CreateOrder()  {
        int flag = 0;
        List<OrderLine> orderLines = new ArrayList<>();
        List<Product> products;
        try {
        products = service.performAction("0");
        UUID orderId = UUID.randomUUID();
        double totalCost = 0;
        do {
            int productId = view.getIntValue("\nEnter product № you want to add to order: ");
            int amount = view.getIntValue("Enter amount of selected product:");
            for (Product product:products) {
                if(productId == product.getId()) {
                    orderLines.add(new OrderLine(orderId, productId, amount, product.getPrice() * amount));
                    totalCost += product.getPrice() * amount;
                }
            }
            view.printData(products,view.catalogueColumns);
             flag = view.getIntValue("1. Continue adding products\n2. Save order");
        } while (flag != 2);

        BaseService<String, Order> createOrderService = serviceFactory.createService("create order");
        view.printMessage(createOrderService.performAction(new Order(orderId,UserSession.getUserSession().getUserId(),totalCost,"registered")));
        BaseService<String,OrderLine> addOrderLineService = serviceFactory.createService("add orderLine");
        for (OrderLine orderLine: orderLines) {
            addOrderLineService.performAction(orderLine);
        }}catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }


    }

}
