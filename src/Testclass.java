

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


    public Testclass() {
        c = getContentPane();
        c.setLayout(new BorderLayout());

        passwordScreen = new JTextArea("Space to show passwords");


        //Sets Font
        Font font = new Font("Arial", Font.PLAIN , 12);
        passwordScreen.setFont(font);
        sp = new JScrollPane(passwordScreen);

        //Sets page layout

        passwordScreen.setLineWrap(true);
        passwordScreen.setWrapStyleWord(true);

        //adds the components
        c.add(passwordScreen, BorderLayout.CENTER);
        c.add(sp);


        String[] species = new String[] {"Letters", "Numbers", "Good to remember"};
        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies, BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        Testclass Window = new Testclass();
        Window.setTitle("Password Generator");
        Window.setSize(240, 160);
        Window.setVisible(true);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
