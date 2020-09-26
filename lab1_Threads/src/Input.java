import java.io.File;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static File getDirectory() {
        File directory;
        while (true) {
            System.out.print("Enter directory path -> ");
            String directoryName = scanner.nextLine();
            directory = new File(directoryName);
            if (!directory.exists()) {
                System.err.println("Error! Directory doesn't exist or you entered incorrect path");
            } else if (!directory.isDirectory()) {
                System.err.println("Error! Entered path isn`t a directory");
            } else break;
        }
        return directory;
    }

    public static int getNumber(String minMax) {
        String string;
        while (true) {
            System.out.print("Enter " + minMax + " -> ");
            string = scanner.nextLine();
            if (!(string.matches("\\d+"))) {
                System.err.println("Error! Enter only numbers without space!");
            } else break;
        }
        return Integer.parseInt(string);
    }
    public static int getMaxNumber(int minValue,String minMax){
       Integer maxValue;
        while (true){
            maxValue = getNumber(minMax);
            if(maxValue.compareTo(minValue) <= 0)
                System.err.println("maxNumber must be bigger than minValue");
            else break;
        }return maxValue;
    }
}
