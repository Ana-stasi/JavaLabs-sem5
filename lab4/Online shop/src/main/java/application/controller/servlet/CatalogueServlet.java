package application.controller.servlet;

import application.controller.command.Command;
import application.controller.command.CommandList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext cont = req.getServletContext();

        Command command = CommandList.CATALOGUE.getCommand();
        String path = command.execute(req, resp);
        cont.getRequestDispatcher(path).forward(req, resp);
    }
}
