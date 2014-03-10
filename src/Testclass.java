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
    JSlider passwordLengthSlider;


    public Testclass() {
         c = getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));


        /**
         * Adds comobo Box
         */
        String[] species = new String[] {"Letters", "Numbers", "Letters & Numbers", "Good to remember", "Random"};
        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies);

        /**
         * Adds JSlider to change password length
         */
        passwordLengthSlider = new JSlider( 0, 100, 50 );
        passwordLengthSlider.setPaintTicks( true );
        passwordLengthSlider.setMinorTickSpacing(5);
        c.add( passwordLengthSlider );


        /**
         * Adds Textarea and its properties
         */
        passwordScreen = new JTextArea("Space to show passwords", 5, 10);
        passwordScreen.setEditable(false);

        //sets Font
        Font font = new Font("Arial", Font.BOLD, 12);
        passwordScreen.setFont(font);

        //sets page layout
        passwordScreen.setLineWrap(true);
        passwordScreen.setWrapStyleWord(true);

        /**
         * Adds scroll pane to the Text Area
         */
        sp = new JScrollPane(passwordScreen);
        c.add(sp);


        /**
         * Adds 'create' button
         */
        createButton = new JButton("Create Password");
        c.add(createButton);
    }


    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
        Testclass gui = new Testclass();
        gui.setTitle("Password Generator");
        gui.setSize(240, 240);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
