import java.util.ArrayList;
import java.util.List;

public abstract class PasswordSource  {

    protected List<Character> chars = new ArrayList<Character>();

    public String getRandomString() {
        int random = (int)(Math.random() * chars.size() - 1);
        return chars.get(random).toString();
    }
}
