package controller.command;

import exceptions.InvalidTypeException;
import exceptions.NoSuchUserException;
import model.entity.User;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.List;

public class EditUserStatusCommand extends FrontCommand {
    public EditUserStatusCommand(PageView view, String request) {
        super(view, request);
    }

    @Override
    public void execute() {
        try {
            BaseService<List<User>,String > showUsersService = serviceFactory.createService("show users");
            BaseService<String, User> userStatusService = serviceFactory.createService(request);
            view.printData(showUsersService.performAction(""),view.userColumns);
            String username = view.getRequest("Type username:");
            String block = view.getBlockRequest();
            if(block.equals("block"))
                view.printMessage(userStatusService.performAction(new User(username,false)));
            else view.printMessage(userStatusService.performAction(new User(username,true)));
        } catch(InvalidTypeException| NoSuchUserException e){
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }
}
