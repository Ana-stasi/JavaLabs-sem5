package view.page;

import exceptions.WrongInputException;
import exceptions.WrongMenuItemException;
import model.entity.UserSession;
import view.Validator;

public class AdminPage extends PageView {

    @Override
    public void showMenu() {
        printMessage("\n[ "+ UserSession.getUserSession().getUsername()+" ]"+
                " \n\t~~~~~~ MENU ~~~~~~\n " +
                "- view catalogue -\n " +
                "- add product -\n " +
                "- delete product-\n " +
                "- edit product -\n " +
                "- block/unblock user -\n " +
                "- edit order status -\n " +
                "- log out -\n");
    }

    @Override
    public int getValueByItem(String request,int max) {
        String value;
        while (true) {
            value = getRequest(request);
            try {
                Validator.checkMenuItem(value,max);
                break;
            }catch (WrongInputException| WrongMenuItemException e ) {
                printErrorMessage(e.getMessage());
            }
        } return Integer.parseInt(value);
    }
    @Override
    public String getBlockRequest() {
        String blockRequest;
        while (true) {
            blockRequest = getRequest(" - block - \n - unblock -\n Select option ->  ");
            try {
                Validator.checkBlockRequest(blockRequest);
                break;
            } catch (WrongMenuItemException e) {
                printErrorMessage(e.getMessage());
            }
        } return blockRequest;
    }
}
