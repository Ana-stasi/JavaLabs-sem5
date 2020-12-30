package application.controller.command.impl;


import application.controller.command.AbstractCommand;
import application.controller.util.Validator;
import application.controller.util.constants.Pages;
import application.controller.util.constants.Servlets;
import application.model.dto.RegisterDTO;
import application.model.exception.MySQLException;
import application.model.exception.UnsupportedUsernameException;
import application.model.exception.WrongPasswordException;
import application.model.service.RegistrationService;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand extends AbstractCommand {
    private RegistrationService service;
    final static Logger logger = Logger.getLogger(RegistrationCommand.class);

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
            logger.info(request.getParameter("user_name")+" was successfully registered");
        } catch (UnsupportedUsernameException | WrongPasswordException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Servlets.REGISTER);
            logger.error("User with unsupported username or unconfirmed password tried to register");
        } catch (MySQLException e) {
            setErrorRequest(request, response, getMessage(request,e.getMessage()), Servlets.LOGIN);
            logger.fatal("System error, caused by problems with database");
        }
        request.setAttribute("success", getMessage(request,registerResult));
        request.setAttribute("pagelink", Servlets.LOGIN);
        return Pages.SUCCESS;
    }

    private RegisterDTO getUserData(HttpServletRequest req) {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        return new RegisterDTO(username, password, email);
    }

}
