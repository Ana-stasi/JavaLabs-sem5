package controller;

import controller.command.*;
import exceptions.WrongMenuItemException;
import model.entity.UserSession;
import view.page.PageView;

class Dispatcher {
    void executeCommand(String request, PageView view)  {
        switch (request) {
            case "login":
               new LoginCommand(view,request).execute();
                break;
            case "sign up":
                new SignUpCommand(view,request).execute();
                break;
            case "view catalogue":
                new ShowCatalogueCommand(view,request).execute();
                break;
            case"view orders":
                new ShowOrdersCommand(view,request).execute();
                break;
            case"add product":
                new AddProductCommand(view,request).execute();
                break;
            case"delete product":
                new DeleteProductCommand(view,request).execute();
                break;
            case"block/unblock user":
                new EditUserStatusCommand(view,request).execute();
                break;
            case"edit product":
                new EditProductCommand(view, request).execute();
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
