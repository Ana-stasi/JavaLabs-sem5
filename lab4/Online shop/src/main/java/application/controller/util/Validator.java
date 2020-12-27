package application.controller.util;


import application.model.exception.UnsupportedUsernameException;
import application.model.exception.WrongInputException;
import application.model.exception.WrongPasswordException;

import javax.servlet.http.HttpServletRequest;

public class Validator {
    public static void checkPassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirm_password");
        if (!password.equals(confirmPass))
            throw new WrongPasswordException();
    }

    public static void checkUsername(HttpServletRequest request) throws UnsupportedUsernameException {
        String username = request.getParameter("user_name");
        if (!username.matches("^[a-z0-9_-]{3,15}$"))
            throw new UnsupportedUsernameException();
    }

    public static void checkDouble(String attribute, String attributeName) throws WrongInputException {
        try {
            Double.parseDouble(attribute);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong " + attributeName + ".Enter only number values");
        }

    }
}
