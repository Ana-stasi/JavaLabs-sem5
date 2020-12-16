package view;

import exceptions.*;

public class Validator {

    public static void checkUsername(String username) throws UnsupportedUsernameException {
        if (!username.matches("^[a-z0-9_-]{3,15}$"))
            throw new UnsupportedUsernameException();
    }

    public static void checkUserType(String userType) throws UnsupportedUserTypeException {
        if (!(userType.equals("admin")||userType.equals("user")))
                throw new UnsupportedUserTypeException();
    }

    public static void checkPassword(String pass, String confirmPass){
        if(!pass.equals(confirmPass))
            throw new WrongPasswordException();
    }
    public static void checkEmail(String email){
        if (!email.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$"))
            throw new UnsupportedEmailException();
    }
    public static void checkMenuItem(String sortType,int max){
        if(sortType.matches("\\d+")){
            int type = Integer.parseInt(sortType);
            if(type > max || type < 1) throw new WrongMenuItemException();;
        }else throw new WrongInputException();
    }
    public static  void checkBlockRequest(String request){
        if(!(request.equals("block") || request.equals("unblock")))
            throw new WrongMenuItemException();
    }

}
