package lab3.view.page;

import lab3.controller.exceptions.WrongInputException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.model.entity.UserSession;
import lab3.view.Validator;

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
    public int getOrderStatus() {
        String orderStatusRequest;
        while (true) {
            orderStatusRequest = getRequest(" 1.registered \n 2.paid \n 3.canceled\n Select option ->  ");
            try {
                Validator.checkMenuItem(orderStatusRequest,3);
                break;
            } catch (WrongMenuItemException e) {
                printErrorMessage(e.getMessage());
            }
        } return Integer.parseInt(orderStatusRequest);
    }
}
