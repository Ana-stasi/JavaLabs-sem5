package lab3.controller.command;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.model.entity.Category;
import lab3.model.entity.Color;
import lab3.model.entity.Product;
import lab3.model.service.ProductService;
import lab3.model.service.CategoryService;
import lab3.model.service.ColorService;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.view.page.PageView;

import java.sql.SQLException;
import java.util.List;


public class AddProductCommand extends FrontCommand {

    private CategoryService categoryService;
    private ColorService colorService;
    private ProductService productService;

    public AddProductCommand(PageView view) {
        super(view);
        categoryService = new CategoryService();
        colorService = new ColorService();
        productService = new ProductService();
    }

    @Override
    public void execute() {
        try {
          Product product = getProduct();
            view.printMessage(productService.addProduct(product));
        }catch (InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private Product getProduct(){
        Product product = null;
        try {
            Category category = getCategory();
            String name = view.getRequest("Type product name:");
            double price = view.getDouble("Type price:");
            Color color = getColor();
            double weight = view.getDouble("Type weight:");
            product = new Product(category,name,price,color,weight);
        }catch (EmptyCatalogueException e){
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        return product;
    }

    private Color getColor() throws EmptyCatalogueException,SQLException {
            view.printData(colorService.getColors(),"\t№ \t\t color name");
            int colorId = view.getIntValue("Input color №:");
        return colorService.findColor(colorId);
    }

    private Category getCategory()throws EmptyCatalogueException,SQLException{
        view.printData(categoryService.getCategories(),"\t№ \t\tcategory name");
        int categoryId = view.getIntValue("Input category №:");
        return categoryService.findCategory(categoryId);
    }

}
