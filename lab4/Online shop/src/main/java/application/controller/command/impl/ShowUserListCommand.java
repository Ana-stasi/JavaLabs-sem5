package application.controller.command.impl;

import application.controller.util.Pagination;
import application.controller.util.constants.Pages;
import application.domain.User;
import application.model.exception.MySQLException;
import application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowUserListCommand extends AbstractCommand {
    private UserService service;

    public ShowUserListCommand() {
        this.service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = service.getUsers();
            new Pagination().configure(request, 3, "users", users);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Pages.START_PAGE);
        }
        return Pages.USERS;
    }
}
