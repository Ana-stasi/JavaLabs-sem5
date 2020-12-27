package application.controller.command.impl;


import application.controller.util.Validator;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.model.dto.RegisterDTO;
import application.model.exception.MySQLException;
import application.model.exception.UnsupportedUsernameException;
import application.model.exception.WrongPasswordException;
import application.model.service.RegistrationService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationCommand extends AbstractCommand {
    private RegistrationService service;

    public RegistrationCommand() {
        this.service = new RegistrationService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerResult = null;
        try {
            Validator.checkUsername(request);
            Validator.checkPassword(request);
            registerResult = service.register(getUserData(request));
        } catch (UnsupportedUsernameException | WrongPasswordException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.REGISTER);
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), Servlets.LOGIN);
        }
        request.setAttribute("success", registerResult);
        request.setAttribute("pagelink", Servlets.LOGIN);
        return Pages.SUCCESS;
    }

    private RegisterDTO getUserData(HttpServletRequest req) {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        ;
        return new RegisterDTO(username, password, email);
    }

}
