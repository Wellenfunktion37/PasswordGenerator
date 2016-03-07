//TODO Länge der Zufallsworte begrenzen
//TODO GUI Erstellung in eigene Klasse auslagern

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

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
    JButton createPasswordButton;
    JSlider passwordLengthSlider;
    JProgressBar passwordSecurityLevel;

    public Testclass() {
        c = getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        /**
         * Adds comobo Box
         */
        SelectOption[] species = new SelectOption[] {
                new SelectOption("Letters", new PasswordSource[] { new LetterSource() }),
                new SelectOption("Numbers", new PasswordSource[] { new NumberSource() }),
                new SelectOption("Letters & Numbers", new PasswordSource[] { new LetterSource(), new NumberSource()}),
                new SelectOption("Words", new PasswordSource[] { new WordSource(), new SpecialCharSource() }),
                new SelectOption("Special characters", new PasswordSource[] { new SpecialCharSource() }),
                new SelectOption("Random", new PasswordSource[] { new LetterSource(), new NumberSource(),
                                           new SpecialCharSource(), new WordSource() })
        };

        passwordSpecies = new JComboBox(species);
        c.add(passwordSpecies);
        passwordSpecies.setToolTipText("Choose password species");

        /**
         * Adds JSlider to change password length
         */
        passwordLengthSlider = new JSlider( 5, 100, 12 );
        passwordLengthSlider.setPaintTicks(true);
        passwordLengthSlider.setPaintLabels(true);
        passwordLengthSlider.setLabelTable(passwordLengthSlider.createStandardLabels(22));
        passwordLengthSlider.setMinorTickSpacing(5);

        c.add( passwordLengthSlider );
        passwordLengthSlider.setToolTipText("Move Slidebar to change password length");


        /**
         * Adds a progressbar to visualize the password security level
         */
        passwordSecurityLevel = new JProgressBar();
        c.add(passwordSecurityLevel);

        //allows to show Strings in progressbar
        passwordSecurityLevel.setStringPainted(true);

        //shows password length in progressbar
        passwordSecurityLevel.setString("Length: " + passwordLengthSlider.getValue());
        passwordSecurityLevel.setValue(passwordLengthSlider.getValue());
        passwordSecurityLevel.setMaximum(100);
        passwordSecurityLevel.setMinimum(0);

        passwordLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                passwordSecurityLevel.setValue(passwordLengthSlider.getValue());
                passwordSecurityLevel.setString("Length: " + passwordSecurityLevel.getValue());
            }
        });

        passwordSecurityLevel.setBorder(new EmptyBorder(0, 0, 10, 0));


        /**
         * Adds Textarea and its properties
         */
        passwordScreen = new JTextArea("No Password yet created", 5, 10);
        passwordScreen.setEditable(false);

        //sets Font
        Font font = new Font("Helvetica", Font.PLAIN, 15);
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
         *'create' button
         */
        createPasswordButton = new JButton("Create Password");
        createPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = passwordSpecies.getSelectedItem();
                if (item instanceof SelectOption) {
                    SelectOption option = (SelectOption)item;
                    generatePassword(option.getSources());
                }
            }
        });

        c.add(createPasswordButton);
        createPasswordButton.setToolTipText("Push Button to create a new password");
    }

    /**
     * private class to select the password species
     */

    private class SelectOption {
        private String name;
        private PasswordSource[] sources;

        public SelectOption(String name, PasswordSource[] sources) {
            this.name = name;
            this.sources = sources;
        }

        public PasswordSource[] getSources() {
            return this.sources;
        }

        public String toString() {
            return this.name;
        }
    }

    /**
     * Creates password depending on length and source
     * @param sources
     */
    public void generatePassword(PasswordSource[] sources) {
        String password = PasswordGenerator.generate(sources, passwordLengthSlider.getValue());
        passwordScreen.setText(password);
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
