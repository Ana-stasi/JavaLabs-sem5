package application.controller.servlet.user;

import application.controller.command.Command;
import application.controller.command.CommandList;
import application.controller.util.constants.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateOrderServlet",urlPatterns = {"/create"})
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher reqDisp = req.getRequestDispatcher(Pages.CREATE_ORDER);
        reqDisp.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();
        Command command = CommandList.CREATE_ORDER.getCommand();
        String path = command.execute(req,resp);
        cont.getRequestDispatcher(path).forward(req,resp);
    }
}
