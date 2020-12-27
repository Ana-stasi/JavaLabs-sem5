
package application.controller.command.impl;

import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.User;
import application.model.dto.LoginDTO;
import application.model.exception.BlockedUserException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;
import application.model.exception.WrongPasswordException;
import application.model.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginCommand extends AbstractCommand {
    private LoginService service;

    public LoginCommand() {
        service = new LoginService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = null;
        try {
            User user = service.login(getUserData(request));
            session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
        } catch (NoSuchUserException | WrongPasswordException | BlockedUserException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.LOGIN);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.LOGIN);
        }
        request.setAttribute("success", "Welcome,  " + session.getAttribute("username") + "! ");
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private LoginDTO getUserData(HttpServletRequest req) {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        return new LoginDTO(username, password);
    }

}
