package lab3.view.page;

import lab3.controller.exceptions.WrongInputException;
import lab3.controller.exceptions.WrongMenuItemException;
import lab3.view.Validator;

import java.util.List;
import java.util.Scanner;

public abstract class PageView implements Printer,  InputReader{
    public  final String userColumns = String.format("%15s |%35s | %10s", "username","email","status\n");
    public final String catalogueColumns = String.format("%3s |%20s | %30s | %2s\t | %15s | %2s\t | %10s\n",
            "№","category","name","price","color","weight","date added");
    public final String orderColumns = String.format("%15s |%15s  |%15s  | %10s","username","price","status","creation date");

    private static Scanner scanner = new Scanner(System.in);

    public abstract void showMenu();

    public String getRequest(String request) {
            printMessage(request);
            return scanner.nextLine();
    }
    public <E> void  printData(List<E> data, String columnsNames){
        printMessage(columnsNames);
        for (E entity: data) {
            printMessage(entity.toString());
        }
    }
    public void showCatalogueSortMenu(){
        printMessage("Sort catalogue:\n" +
                "1. By name ( A - Z)\n"+
                "2. By name (Z - A)\n" +
                "3. By price (cheap - expensive)\n" +
                "4. By price (expensive - cheap)\n" +
                "5. By date added\n");
    }
    public String getSortType(int max){
        String sortType;
        while (true) {
            sortType = getRequest("Select sortType:");
            try {
                Validator.checkMenuItem(sortType,max);
                break;
            }catch (WrongInputException | WrongMenuItemException e){
                printErrorMessage(e.getMessage());
            }
        }
        return sortType;
    }
    @Override
    public int getIntValue(String string){
        int value;
        while (true) {
            String str = getRequest(string);
            try {
                value = Integer.parseInt(str);
                break;
            }catch ( NumberFormatException e) {
                printErrorMessage(e.getMessage());
            }
        } return value;
    }
    @Override
    public double getDouble(String string) {
        Double value;
        while (true) {
            String str = getRequest(string);
            try {
                value = Double.parseDouble(str);
                break;
            }catch ( NumberFormatException e) {
                printErrorMessage(e.getMessage());
            }
        } return value;
    }
}
