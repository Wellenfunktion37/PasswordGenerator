import java.util.List;

/**
 * Created by philipp on 13.03.14.
 */
public class PasswordGenerator {

    public static String generate(PasswordSource[] sources, int length) {
        String password = "";
        for (int i = 0; i <= length; i++) {
            PasswordSource randomSource = getRandomSource(sources);
            password += randomSource.getRandomString();
        }

        return password;
    }

    private static PasswordSource getRandomSource(PasswordSource[] sources) {
        int random = (int)(Math.random() * sources.length);
        return sources[random];
    }


}
