package model.service;

import exceptions.InvalidTypeException;

public class ServiceFactory {
    private static volatile ServiceFactory serviceFactory = null;

    private ServiceFactory() {
    }

    public static ServiceFactory getServiceFactory() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) // check again within synchronized block to guard for race condition
                    serviceFactory = new ServiceFactory();
            }
        }
        return serviceFactory;
    }

    public BaseService createService(String request) throws InvalidTypeException {

        switch (request) {
            case "login":
                return new LoginService();
            case "sign up":
                return new RegistrationService();
            case "view catalogue":
                return new ShowCatalogueService();
            case "show users":
                return new ShowUsersService();
            case"create order":
                return new CreateOrderService();
            case "add orderLine":
                return new AddOrderLinesService();
            case"view orders":
                return new ShowOrdersService();
            case "add product":
                return new AddProductService();
            case "edit product":
                return new EditProductService();
            case "delete product":
                return new DeleteProductService();
            case "block/unblock user":
                return new EditUserStatusService();
            case"get categories":
                return new ShowCategoryService();
            case "get colors":
                return new ShowColorService();
            default:
                throw new InvalidTypeException();
        }
    }
}
