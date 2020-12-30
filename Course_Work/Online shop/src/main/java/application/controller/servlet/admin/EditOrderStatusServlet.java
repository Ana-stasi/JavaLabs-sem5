package application.controller.servlet.admin;

import application.controller.command.CommandList;
import application.controller.command.Command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditOrderStatusServlet", urlPatterns = "/order_status")
public class EditOrderStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();
        Command command = CommandList.VIEW_ORDERS.getCommand();
        String path = command.execute(req, resp);
        cont.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();
        Command command = CommandList.EDIT_ORDER_STATUS.getCommand();
        String path = command.execute(req, resp);
        cont.getRequestDispatcher(path).forward(req, resp);
    }
}
