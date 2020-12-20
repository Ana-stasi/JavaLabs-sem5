package lab3.controller.command;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.controller.exceptions.NoSuchUserException;
import lab3.model.entity.User;
import lab3.model.service.UserService;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.view.page.PageView;

import java.sql.SQLException;

public class EditUserStatusCommand extends FrontCommand {
    private UserService  service;
    public EditUserStatusCommand(PageView view) {
        super(view);
        this.service = new UserService();
    }

    @Override
    public void execute() {
        try {
            User user = getUser();
            String block = view.getBlockRequest();
            if(block.equals("block"))
                view.printMessage(service.editStatus(new User(user.getUsername(),false)));
            else view.printMessage(service.editStatus(new User(user.getUsername(),true)));
        } catch(InvalidTypeException| NoSuchUserException| EmptyCatalogueException e){
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private User getUser() throws NoSuchUserException{
        User user = null;
        try {
            view.printData(service.getUsers(),view.userColumns);
            String username = view.getRequest("Type username:");
            user = service.findByName(username);
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
       return user;
    }
}
