package application.controller.servlet.common;

import application.controller.command.impl.LoginCommand;
import application.controller.util.constants.Pages;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LogoutServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();
        logger.info("User "+req.getSession().getAttribute("username")+"logged out");
        req.getSession().invalidate();
        cont.getRequestDispatcher(Pages.START_PAGE).forward(req, resp);
    }
}
