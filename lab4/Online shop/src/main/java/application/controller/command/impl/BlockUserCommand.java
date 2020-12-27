package application.controller.command.impl;

import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.domain.User;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;
import application.model.exception.WrongInputException;
import application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockUserCommand extends AbstractCommand {
    private UserService service;

    public BlockUserCommand() {
        this.service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blockResult = "";
        try {
            User user = getUser(request);
            Boolean userStatus = getStatus(request, user);
            blockResult = service.editStatus(new User(user.getUsername(), userStatus));
        } catch (WrongInputException | NoSuchUserException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.BLOCK_USER);
        } catch (MySQLException e) {
            setErrorRequest(request, response,e.getMessage(), Pages.START_PAGE);
        }
        request.setAttribute("success", blockResult);
        request.setAttribute("pagelink", Servlets.VIEW_CATALOGUE);
        return Pages.SUCCESS;
    }

    private User getUser(HttpServletRequest req) throws NoSuchUserException, MySQLException {
        User user = null;
        String username = req.getParameter("username");
        user = service.findByName(username);
        return user;
    }

    private Boolean getStatus(HttpServletRequest req, User user) throws WrongInputException {
        String status = "";
        Boolean userStatus = null;
        String[] statuses = req.getParameterValues("status");
        for (String s : statuses) {
            if (!s.equals("Status")) status = s;
        }
        if (!status.isEmpty()) {
            if (user.isEnable() == Boolean.parseBoolean(status))
                throw new WrongInputException("User is already " + user.getEnable());
            else userStatus = Boolean.parseBoolean(status);
        }
        return userStatus;
    }
}
