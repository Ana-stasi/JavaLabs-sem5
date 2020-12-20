package lab3.controller;

import lab3.controller.exceptions.BlockedUserException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.UserSession;
import lab3.view.page.AdminPage;
import lab3.view.page.PageView;
import lab3.view.page.UnauthorizedUserPage;
import lab3.view.page.UserPage;

public class FrontController {
    public void run() {
        UserSession userSession;
        while (true) {
            userSession = UserSession.getUserSession();
            PageView view = getView(userSession.getRole());
            view.showMenu();
            try {
                String request = view.getRequest("Select action:");
                new Dispatcher().executeCommand(request, view);
            } catch (WrongMenuItemException  | BlockedUserException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private PageView getView(String userRole) {
        switch (userRole) {
            case "admin":
                return new AdminPage();
            case "user":
                return new UserPage();
            default:
                return new UnauthorizedUserPage();
        }
    }


}

