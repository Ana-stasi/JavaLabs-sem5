package application.controller.util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Pagination {
    public void configure(HttpServletRequest request, int pageSize, String attribute, List data) {
        if (data != null) {
            if (data.size() > pageSize) {
                int lastP = (data.size() / pageSize) + 1;
                request.setAttribute("lastPage", lastP);
                if (request.getParameter("page") == null) {
                    request.setAttribute(attribute, data.subList(0, pageSize));
                    request.setAttribute("page", 1);
                } else {
                    int page = Integer.parseInt(request.getParameter("page"));
                    if (page == lastP) {
                        request.setAttribute(attribute, data.subList((page - 1) * pageSize, data.size()));
                    } else
                        request.setAttribute(attribute, data.subList((page - 1) * pageSize, page * pageSize));
                    request.setAttribute("page", page);
                }
            } else
                request.setAttribute(attribute, data);
        } else
            request.setAttribute(attribute, data);
    }
}
