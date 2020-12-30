package application.controller.command;

import application.controller.command.Command;
import application.controller.command.impl.LoginCommand;
import application.controller.util.constants.Pages;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class AbstractCommand implements Command {

    public String getSortType(HttpServletRequest request) {
        String sortType = "none";
        Iterator<String> it = request.getParameterNames().asIterator();
        while (it.hasNext()) {
            String name = it.next();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                if (!value.equals("none"))
                    sortType = value;
            }
        }
        return sortType;
    }

    public void setErrorRequest(HttpServletRequest req, HttpServletResponse resp, String errMessage, String page) throws ServletException, IOException {
        req.setAttribute("error", errMessage);
        req.setAttribute("pagelink", page);
        req.getRequestDispatcher(Pages.ERROR).forward(req, resp);
    }
    public String getMessage(HttpServletRequest req,String label) {
        String lang = (String) req.getSession(true).getAttribute("lang");
        if(lang == null) lang ="ukr";
        return ResourceBundle.getBundle("language",new Locale(lang)).getString(label);
    }
}
