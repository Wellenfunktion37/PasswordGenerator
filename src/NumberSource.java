public class NumberSource extends PasswordSource {
    public NumberSource() {
        // add numbers
        for (int i = 48; i <= 57; i++) {
            chars.add(String.valueOf((char)i));
        }
    }

    public String toString() {
        return "Numbers";
    }
}
