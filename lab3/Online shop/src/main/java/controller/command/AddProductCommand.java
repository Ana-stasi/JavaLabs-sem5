package controller.command;

import exceptions.InvalidTypeException;
import model.entity.Category;
import model.entity.Color;
import model.entity.Product;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.List;


public class AddProductCommand extends FrontCommand {

    public AddProductCommand(PageView view, String request) {
        super(view, request);
    }

    @Override
    public void execute() {
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

            BaseService<String,Product> addProductService = serviceFactory.createService(request);
            Product product = new Product(new Category(category),name,price,new Color(color),weight);
            view.printMessage(addProductService.performAction(product));
        }catch (InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

}
