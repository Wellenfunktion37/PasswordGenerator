import java.util.List;

/**
 * Generates Password
 */
public class PasswordGenerator {

    /**
     *
     * @param sources chosen kind of password
     * @param length password length
     * @return the generated password
     */
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
