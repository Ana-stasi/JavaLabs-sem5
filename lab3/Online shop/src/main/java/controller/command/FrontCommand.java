package controller.command;

import model.service.ServiceFactory;
import view.page.PageView;

public abstract class FrontCommand{
    protected PageView view;
    protected ServiceFactory serviceFactory;
    protected String request;

    FrontCommand(PageView view,String request) {
       this.view = view;
       this.serviceFactory = ServiceFactory.getServiceFactory();
       this.request = request;
    }

    abstract void execute();

}
