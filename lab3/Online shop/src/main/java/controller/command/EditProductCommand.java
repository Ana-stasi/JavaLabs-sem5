package lab3.controller.command;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.Category;
import lab3.model.entity.Color;
import lab3.model.entity.Product;
import lab3.model.service.*;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.view.page.PageView;


import java.sql.SQLException;
import java.util.List;

public class EditProductCommand extends FrontCommand {

    private CategoryService categoryService;
    private ColorService colorService;
    private ProductService productService;

    public EditProductCommand(PageView view) {
        super(view);
        categoryService = new CategoryService();
        colorService = new ColorService();
        productService = new ProductService();
    }

    @Override
    public void execute()  {
        try {
            view.printData(getCatalogue(),view.catalogueColumns);
            Product product = getProduct();
            String confirmAnswer = view.getRequest("Are you sure you want to change product №"+product.getId()+" ? [y/n]");
            if(confirmAnswer.equalsIgnoreCase("y")){
              Product newProduct = editProduct(product.getId()) ;
              productService.updateProduct(newProduct);
            }
        } catch (EmptyCatalogueException |InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
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

    private Product editProduct(int productId){
        Product product = null;
        try {
            Category category = getCategory();
            String name = view.getRequest("Type product name:");
            double price = view.getDouble("Type price:");
            Color color = getColor();
            double weight = view.getDouble("Type weight:");
            product = new Product(productId,category,name,price,color,weight);
        }catch (EmptyCatalogueException e){
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
        return product;
    }
    private Product getProduct() throws EmptyCatalogueException, SQLException {
        int productId = view.getIntValue("\nEnter product № you want to edit: ");
        return productService.findProduct(productId);
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
