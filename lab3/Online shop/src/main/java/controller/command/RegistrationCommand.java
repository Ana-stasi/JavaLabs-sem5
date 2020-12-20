package lab3.controller.command;

import lab3.model.entity.User;
import lab3.model.service.RegistrationService;
import lab3.view.page.PageView;

import java.sql.SQLException;


public class RegistrationCommand extends FrontCommand {

    private RegistrationService service;

    public RegistrationCommand(PageView view) {
        super(view);
        this.service = new RegistrationService();
    }

    public void execute() {
        try {
            User user = getUserData();
            view.printMessage(service.register(user));
        } catch (SQLException e) {
            view.printErrorMessage(view.SYSTEM_ERROR);
        }
    }

    private User getUserData() {
        String userRole = view.getUserRole();
        String username = view.getUsername();
        String password = view.getPassword();
        String email = view.getEmail();
        return new User(userRole, username, password, email);
    }
}
