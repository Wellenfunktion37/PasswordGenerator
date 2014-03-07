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
    JTextArea passwordScreen;
    JScrollPane sp;
    JButton createButton;


    public Testclass() {
         c = getContentPane();

        /**
         * Flow Layout
         * TODO change Layout
         * TODO ScrollPane does not work
         */
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        passwordScreen = new JTextArea("Space to show passwords", 5, 10);

        //Sets Font
        Font font = new Font("Arial", Font.BOLD, 12);
        passwordScreen.setFont(font);

        //Sets page layout
        passwordScreen.setLineWrap(true);
        passwordScreen.setWrapStyleWord(true);

        sp = new JScrollPane(passwordScreen);

        //adds the components
        c.add(sp);

        createButton = new JButton("create Password");
        c.add(createButton);



        String[] species = new String[] {"Letters", "Numbers", "Good to remember"};
        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies);
    }


    public static void main(String[] args) {
        Testclass gui = new Testclass();
        gui.setTitle("Password Generator");
        gui.setSize(240, 160);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
