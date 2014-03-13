import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSource extends PasswordSource {

    public WordSource() {
        try {
            Scanner scanner = new Scanner(new File("words.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                chars.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
