package lab3.controller;


import lab3.controller.command.*;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.UserSession;
import lab3.view.page.PageView;

class Dispatcher {
    void executeCommand(String request, PageView view)  {
        switch (request) {
            case "login":
               new LoginCommand(view).execute();
                break;
            case "sign up":
                new RegistrationCommand(view).execute();
                break;
            case "view catalogue":
                new ShowCatalogueCommand(view).execute();
                break;
            case"view orders":
                new ShowOrdersCommand(view).execute();
                break;
            case"add product":
                new AddProductCommand(view).execute();
                break;
            case"delete product":
                new DeleteProductCommand(view).execute();
                break;
            case"block/unblock user":
                new EditUserStatusCommand(view).execute();
                break;
            case"edit product":
                new EditProductCommand(view).execute();
                break;
            case "edit order status":
                new EditOrderStatusCommand(view).execute();
                break;
            case"log out":
                UserSession.getUserSession().setRole("guest");
                UserSession.getUserSession().setUsername("guest");
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                throw new WrongMenuItemException();
        }

    }
}
