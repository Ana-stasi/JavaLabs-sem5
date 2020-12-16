package view.page;

import java.util.ArrayList;

public interface Printer {
     String SYSTEM_ERROR = "Sorry, something went wrong." +
            "We're working on getting this fixed as soon as we can.";
    void showMenu();
    default void printMessage(String message) {
        System.out.println(message);
    }

    default void printErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }


}
