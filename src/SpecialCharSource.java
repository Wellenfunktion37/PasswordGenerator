public class SpecialCharSource extends PasswordSource {

    public SpecialCharSource() {
        // add special characters part 1
        for (int i = 33; i <= 47; i++) {
            chars.add(String.valueOf((char)i));
        }

        // add special characters part 2
        for (int i = 58; i <= 64; i++) {
            chars.add(String.valueOf((char)i));
        }

        // add special characters part 3
        for (int i = 91; i <= 96; i++) {
            chars.add(String.valueOf((char)i));
        }

        // add special characters part 4
        for (int i = 123; i <= 126; i++) {
            chars.add(String.valueOf((char)i));
        }
    }

    public String toString() {
        return "Special characters";
    }
}
