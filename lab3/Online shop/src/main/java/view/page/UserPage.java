package view.page;

import model.entity.UserSession;

public class UserPage extends PageView {
    @Override
    public void showMenu() {
        printMessage("\n[ "+UserSession.getUserSession().getUsername()+" ]"+
                " \n\t~~~~~~ MENU ~~~~~~\n " +
                "- view catalogue-\n " +
                "- view orders -\n " +
                "- log out -\n");
    }

}