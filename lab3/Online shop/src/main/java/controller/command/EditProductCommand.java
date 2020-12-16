package controller.command;

import exceptions.InvalidTypeException;
import exceptions.WrongMenuItemException;
import model.entity.Category;
import model.entity.Color;
import model.entity.Product;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.List;

public class EditProductCommand extends FrontCommand {

    public EditProductCommand(PageView view, String request) {
        super(view, request);
    }

    @Override
    public void execute()  {

        view.showCatalogueSortMenu();
        try {
            BaseService<List<Product>, String> catalogueService = serviceFactory.createService("view catalogue");
            List<Product> catalogue = catalogueService.performAction("0");
            view.printData(catalogue,view.catalogueColumns);
        } catch (WrongMenuItemException |InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        int productId = view.getIntValue("\nEnter № of product you want to edit: ");
        String confirmAnswer = view.getRequest("Are you sure are you sure you want to change product №"+productId+" ? [y/n]");
        if(confirmAnswer.equalsIgnoreCase("y")){
            updateProduct(productId);
        }
    }

    private void updateProduct(int productId){
        try {
            BaseService<List<Category>, String> categoryService = serviceFactory.createService("get categories");
            List<Category> categories = categoryService.performAction("");

            BaseService<List<Color>,String> colorService = serviceFactory.createService("get colors");
            List<Color> colors = colorService.performAction("");

        view.printData(categories,"\t№ \t\tcategory name");
        int category = view.getValueByItem("Input category №:",categories.size());
        String name = view.getRequest("Type product name:");
        double price = view.getDouble("Type price:");
        view.printData(colors,"\t№ \t\t color name");
        int color = view.getValueByItem("Input color №:",colors.size());
        double weight = view.getDouble("Type weight:");

        BaseService<String,Product> updateService = serviceFactory.createService(request);
        Product product = new Product(productId,new Category(category),name,price,new Color(color),weight);
        view.printMessage(updateService.performAction(product));
        }catch (InvalidTypeException e){
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

}
