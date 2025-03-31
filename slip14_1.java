import java.io.*;
import java.util.concurrent.*;

public class SimpleSearchEngine {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SimpleSearchEngine <search_string>");
            return;
        }
        
        String searchString = args[0];
        File currentDir = new File(".");
        File[] files = currentDir.listFiles((dir, name) -> name.endsWith(".txt"));
        
        if (files == null || files.length == 0) {
            System.out.println("No text files found in the current directory.");
            return;
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(files.length);
        for (File file : files) {
            executor.execute(new SearchTask(file, searchString));
        }
        executor.shutdown();
    }
}

class SearchTask implements Runnable {
    private final File file;
    private final String searchString;

    public SearchTask(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("Found in " + file.getName() + " at line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
        }
    }
}