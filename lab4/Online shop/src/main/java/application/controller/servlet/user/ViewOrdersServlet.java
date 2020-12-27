package application.controller.servlet.user;

import application.controller.command.Command;
import application.controller.command.CommandList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewOrderServlet",urlPatterns = {"/orders"})
public class ViewOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();
        Command command = CommandList.SHOW_ORDERS.getCommand();
        String path = command.execute(req,resp);
        cont.getRequestDispatcher(path).forward(req,resp);
    }
}
