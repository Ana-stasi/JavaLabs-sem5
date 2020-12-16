package controller.command;

import exceptions.InvalidTypeException;
import model.entity.Order;
import model.entity.User;
import model.entity.UserSession;
import model.service.BaseService;
import view.page.PageView;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ShowOrdersCommand extends FrontCommand {
    public ShowOrdersCommand(PageView view, String request) {
        super(view, request);
    }

    @Override
   public void execute() {

        try {
            BaseService<List<Order>, UUID> service = serviceFactory.createService(request);
            List<Order> orders = service.performAction(UserSession.getUserSession().getUserId()) ;
            if(orders == null) view.printMessage("You haven't made any order");
           else view.printData(orders,view.orderColumns);
        }catch ( InvalidTypeException e) {
            view.printErrorMessage(e.getMessage());
        }catch (SQLException e){
            view.printErrorMessage(view.SYSTEM_ERROR);
        }

    }
}
