package controller;

import exceptions.BlockedUserException;
import exceptions.WrongMenuItemException;
import model.entity.User;
import model.entity.UserSession;
import view.page.*;

import java.sql.SQLException;

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

