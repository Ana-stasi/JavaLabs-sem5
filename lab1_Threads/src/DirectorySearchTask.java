import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DirectorySearchTask {

    private int minValue;
    private int maxValue;
    private ExecutorService executor = Executors.newCachedThreadPool();

    DirectorySearchTask(File startDirectory, int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        executor.submit(new DirectoryRunTask(startDirectory));
        try {
            executor.awaitTermination(5_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } executor.shutdown();
    }

    private class DirectoryRunTask implements Runnable {
        
        private File directory;

        private DirectoryRunTask(File directory) {
            this.directory = directory;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start working with directory: " + directory.getName());
            File[] files = directory.listFiles();
            for (File file : files)
                if (file.isDirectory())
                    executor.submit(new DirectoryRunTask(file));
                else if (file.getName().endsWith("cs"))
                    executor.submit(new SearchTask(file));
        }
    }

    private class SearchTask implements Runnable {
        File file;

        SearchTask(File file) {
            this.file = file;
        }

        public void run() {
            try (Scanner scanner = new Scanner(new FileInputStream(file))) {
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    Matcher m = Pattern.compile("\\d+").matcher(str);
                    while (m.find()) {
                        int number = Integer.parseInt(m.group());
                        if (number > minValue && number < maxValue) {
                            System.out.println(Thread.currentThread().getName() + " has found number(s) in " +
                                               file.getName() + " -> \t" + str.trim());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
