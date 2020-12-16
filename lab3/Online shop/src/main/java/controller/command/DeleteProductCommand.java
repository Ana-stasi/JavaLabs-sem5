package controller.command;

import exceptions.InvalidTypeException;
import model.entity.Product;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.List;


public class DeleteProductCommand extends FrontCommand {
    public DeleteProductCommand(PageView view, String request) {
        super(view, request);
    }

    @Override
    public void execute() {
        try {
            BaseService<String, Integer> deleteProductService = serviceFactory.createService(request);
            BaseService<List<Product>, String> showProductsService = serviceFactory.createService("view catalogue");
            List<Product> products = showProductsService.performAction("");
            view.printData(products,view.catalogueColumns);
            int productId = view.getIntValue("Input product №:");
            view.printMessage(deleteProductService.performAction(productId));
        }catch (InvalidTypeException e){
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }
}
