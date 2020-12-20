package lab3.controller.command;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.Product;
import lab3.model.service.ProductService;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.view.page.PageView;

import java.sql.SQLException;
import java.util.List;


public class DeleteProductCommand extends FrontCommand {
    private ProductService service;

    public DeleteProductCommand(PageView view) {
        super(view);
        this.service = new ProductService();
    }

    @Override
    public void execute() {
        try {
            view.printData(getCatalogue(), view.catalogueColumns);
            Product product = getProduct();
            view.printMessage(service.deleteProduct(product.getId()));
        } catch (InvalidTypeException | EmptyCatalogueException e) {
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private List<Product> getCatalogue() {
        view.showCatalogueSortMenu();
        List<Product> products = null;
        try {
            products = service.getProductList(view.getSortType(5));
        } catch (WrongMenuItemException | EmptyCatalogueException e) {
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        return products;
    }

    private Product getProduct() throws EmptyCatalogueException, SQLException {
        int productId = view.getIntValue("\nEnter product № you want to remove: ");
        return service.findProduct(productId);
    }
}
