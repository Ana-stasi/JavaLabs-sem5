package lab3.controller.command;

import lab3.controller.exceptions.WrongInputException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.*;
import lab3.model.service.OrderLineService;
import lab3.model.service.OrderService;
import lab3.model.service.ProductService;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.view.page.PageView;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ShowCatalogueCommand extends FrontCommand {
    private ProductService productService;
    private OrderService orderService;
    private OrderLineService orderLineService;

    public ShowCatalogueCommand(PageView view) {
        super(view);
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.orderLineService = new OrderLineService();
    }

    @Override
    public void execute() {
        if (UserSession.getUserSession().getRole().equals("user"))
            createOrder();
        else view.printData(getCatalogue(), view.catalogueColumns);
    }

    private List<Product> getCatalogue() {
        view.showCatalogueSortMenu();
        List<Product> products = null;
        try {
            products = productService.getProductList(view.getSortType(5));
        } catch (WrongMenuItemException | EmptyCatalogueException e) {
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        return products;
    }

    private void createOrder() {
        try {
            UUID orderId = UUID.randomUUID();
            UUID userId = UserSession.getUserSession().getUserId();
            orderService.addOrder(new Order(orderId, userId));
            double totalCost = selectProducts(orderId);
            if (totalCost != 0)
                view.printMessage(orderService.addOrder(new Order(orderId, userId, totalCost)));
            else
                view.printErrorMessage(orderService.deleteOrder(new Order(orderId, userId, totalCost)));
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private double selectProducts(UUID orderId) {
        double totalCost = 0;
        String flag = "";
        do {
            view.printData(getCatalogue(), view.catalogueColumns);
            try {
                totalCost = addProduct(orderId, totalCost);
            } catch (WrongInputException e) {
                view.printErrorMessage(e.getMessage());
            }
            flag = view.getRequest("Continue adding products? [y/n]");
        } while (!flag.equalsIgnoreCase("n"));
        return totalCost;
    }

    private double addProduct(UUID orderId, double cost) throws WrongInputException {
      double price = 0;
        try {
            Product product = getProduct();
            int amount = view.getIntValue("Enter amount of selected product:");
            price = product.getPrice()*amount;
            OrderLine line = new OrderLine(orderId, product.getId(), amount,price);
            orderLineService.performAction(line);
        }catch (EmptyCatalogueException  e){
            view.printErrorMessage(e.getMessage());
        }
        catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        return cost + price;
    }

    private Product getProduct() throws EmptyCatalogueException,SQLException {
        int productId = view.getIntValue("\nEnter product № you want to add to order: ");
        return productService.findProduct(productId);
    }
}
