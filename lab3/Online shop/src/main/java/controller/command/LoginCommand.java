package lab3.controller.command;

import lab3.controller.exceptions.BlockedUserException;
import lab3.view.page.PageView;
import lab3.controller.exceptions.InvalidTypeException;
import lab3.controller.exceptions.NoSuchUserException;
import lab3.controller.exceptions.WrongPasswordException;
import lab3.model.dto.LoginDTO;
import lab3.model.service.LoginService;


import java.sql.SQLException;

public class LoginCommand extends FrontCommand {

    private LoginService service;

    public LoginCommand(PageView view) {
        super(view);
        this.service = new LoginService();
    }

    @Override
    public void execute() throws BlockedUserException {

        try {
            LoginDTO user = getLoginDTO();
            view.printMessage(service.login(user));
        } catch (NoSuchUserException | WrongPasswordException | InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private LoginDTO getLoginDTO() {
        String username = view.getUsername();
        String password = view.getRequest("Password -> ");
        return new LoginDTO(username, password);
    }
}
