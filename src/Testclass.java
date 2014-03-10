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
         * Adds Textarea and its properties
         */
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        passwordScreen = new JTextArea("Space to show passwords", 5, 10);
        passwordScreen.setEditable(false);

        //sets Font
        Font font = new Font("Arial", Font.BOLD, 12);
        passwordScreen.setFont(font);

        //sets page layout
        passwordScreen.setLineWrap(true);
        passwordScreen.setWrapStyleWord(true);


        /**
         * Adds comobo Box
         */
        String[] species = new String[] {"Letters", "Numbers", "Letters & Numbers", "Good to remember", "Random"};
        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies);

        /**
         * Adds scroll pane to the Text Area
         */
        sp = new JScrollPane(passwordScreen);
        c.add(sp);


        /**
         * Adds 'create' button
         */
        createButton = new JButton("create Password");
        c.add(createButton);
    }


    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
        Testclass gui = new Testclass();
        gui.setTitle("Password Generator");
        gui.setSize(240, 160);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
