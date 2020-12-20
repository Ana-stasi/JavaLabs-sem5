package lab3.controller.command;

import lab3.view.page.PageView;

public abstract class FrontCommand {
    protected PageView view;
    FrontCommand(PageView view){
        this.view = view;
    }
    abstract void execute();
}
