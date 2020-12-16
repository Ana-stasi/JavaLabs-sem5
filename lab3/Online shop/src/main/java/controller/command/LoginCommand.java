package controller.command;

import exceptions.BlockedUserException;
import exceptions.InvalidTypeException;
import exceptions.NoSuchUserException;
import exceptions.WrongPasswordException;
import model.dto.LoginDTO;
import model.entity.User;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;

public class LoginCommand extends FrontCommand{

   public LoginCommand(PageView view,String request){
        super(view,request);
    }

    @Override
    public void execute()throws BlockedUserException {
        BaseService<String,LoginDTO> service = serviceFactory.createService(request);
        String username = view.getUsername();
        String password = view.getRequest("Password -> ");
        try {
            view.printMessage(service.performAction(new LoginDTO(username,password)) );
        }catch (NoSuchUserException| WrongPasswordException| InvalidTypeException e){
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }
}
