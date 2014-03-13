import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    JButton createButton;
    JSlider passwordLengthSlider;
    JLabel passwordLength;

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
                new SelectOption("Good to remember", new PasswordSource[] { new WordSource(), new SpecialCharSource() }),
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
         *
         */
        passwordLength = new JLabel("Length: " + passwordLengthSlider.getValue());
        c.add(passwordLength);
        passwordLength.setBorder(new EmptyBorder(0,0,10,0));
        passwordLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                passwordLength.setText("Length: " + passwordLengthSlider.getValue());
            }
        });

        /**
         * Adds Textarea and its properties
         */
        passwordScreen = new JTextArea("Space to show passwords", 5, 10);
        passwordScreen.setEditable(false);

        //sets Font
        Font font = new Font("Arial", Font.PLAIN, 12);
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
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = passwordSpecies.getSelectedItem();
                if (item instanceof SelectOption) {
                    SelectOption option = (SelectOption)item;
                    generatePassword(option.getSources());
                }
            }
        });

        c.add(createButton);
        createButton.setToolTipText("Push Button to create a new password");
    }

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
