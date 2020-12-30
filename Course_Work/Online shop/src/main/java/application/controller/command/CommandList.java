package application.controller.command;


import application.controller.command.impl.*;

public enum CommandList {
    CHANGE_LOCALE(new ChangeLocaleCommand()),
    LOGIN(new LoginCommand()),
    REGISTER(new RegistrationCommand()),
    CATALOGUE(new ShowCatalogueCommand()),
    DELETE(new DeleteProductCommand()),
    ADD(new AddProductCommand()),
    EDIT(new EditProductCommand()),
    USERS(new ShowUserListCommand()),
    BLOCK(new BlockUserCommand()),
    CREATE_ORDER(new CreateOrderCommand()),
    SHOW_ORDERS(new ShowOrdersCommand()),
    VIEW_ORDERS(new ViewOrdersCommand()),
    EDIT_ORDER_STATUS(new EditOrderStatusCommand());

    private Command command;

    CommandList(Command command)
    {
        this.command = command;
    }
    public Command getCommand(){
        return command;
    }
}
