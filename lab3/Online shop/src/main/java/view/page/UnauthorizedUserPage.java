package view.page;

import exceptions.*;
import model.entity.UserSession;
import view.Validator;

public class UnauthorizedUserPage extends PageView {

    @Override
    public void showMenu() {
        System.out.println("\n\n[ "+ UserSession.getUserSession().getUsername()+" ]\n"+
                " \t~~~~~~ MENU ~~~~~~\n " +
                "- login -\n " +
                "- sign up -\n " +
                "- view catalogue -\n " +
                "- exit -\n");
    }

    public String getUsername(){
        String username;
        while (true) {
            username = getRequest("Username -> ");
            try {
                Validator.checkUsername(username);
                break;
            } catch (UnsupportedUsernameException e) {
                printErrorMessage(e.getMessage());
            }
        } return username;
    }

    public String getUserRole(){
        String userType;
        while (true) {
            userType= getRequest("Select userType (admin, user) -> ");
            try {
                Validator.checkUserType(userType);
                break;
            }catch (UnsupportedUserTypeException e ) {
                printErrorMessage(e.getMessage());
            }
        } return userType;
    }

    public String getPassword(){
        String password;
        while (true) {
            password = getRequest("Password -> ");
            String confirmPass = getRequest("Confirm password ->");
            try {
                Validator.checkPassword(password,confirmPass);
                break;
            } catch (WrongPasswordException e) {
                printErrorMessage(e.getMessage());
            }
        } return password;
    }
 public String getEmail(){
     String email;
     while (true) {
         email = getRequest("Email (example: a.lapa11@gmail.com) -> ");
         try {
             Validator.checkEmail(email);
             break;
         } catch (UnsupportedEmailException e) {
             printErrorMessage(e.getMessage());
         }
     } return email;
 }

}
