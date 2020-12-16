package controller.command;

import model.entity.User;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;


public class SignUpCommand extends FrontCommand{

    public SignUpCommand(PageView view, String request) {
        super(view,request);
    }

    public void execute() {
        BaseService<String,User> service = serviceFactory.createService(request);
        String userRole = view.getUserRole();
        String username = view.getUsername();
        String password = view.getPassword();
        String email = view.getEmail();
        try {
            view.printMessage(service.performAction(new User(userRole,username,password,email)));
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }

    }
}
