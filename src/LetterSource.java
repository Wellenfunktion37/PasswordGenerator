public class LetterSource extends PasswordSource {
    public LetterSource() {
        // add capital letters
        for (int i = 65; i <= 90; i++) {
            chars.add((char)i);
        }

        // add small letters
        for (int i = 97; i <= 122; i++) {
            chars.add((char)i);
        }
    }

    public String toString() {
        return "Letters";
    }
}
