import java.awt.*;
import javax.swing.*;

/**
 * Program to generate secure passwords
 * @author Philipp Butt
 * @version 0.1
 */
public class Testclass extends JFrame {

    Container c;
    JComboBox passwordSpecies;

    public Testclass() {
        c = getContentPane();
        c.setLayout(new FlowLayout());

        String[] species = new String[] {"Letters", "Numbers", "Good to remember"};
        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies);
    }


    public static void main(String[] args) {
        Testclass Window = new Testclass();
        Window.setTitle("Password Generator");
        Window.setSize(240 ,160);
        Window.setVisible(true);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
