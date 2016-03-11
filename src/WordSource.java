import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSource extends PasswordSource {

    /**
     * Reads words out of words.txt to create a 'good to remember' password
     */
    public WordSource() {
        try {
            Scanner scanner = new Scanner(new File("words.txt"));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                chars.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
