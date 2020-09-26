import java.io.File;

public class Main {

    public static void main(String[] args) {
        File directory = Input.getDirectory();
        int minValue = Input.getNumber("minNumber");
        int maxValue = Input.getMaxNumber(minValue,"maxNumber");
        new DirectorySearchTask(directory, minValue, maxValue);
    }
}
