package midlab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    GUI CLASS: @Kurt
        You are free to contribute here, however.
 */
public class Interface {
    JPanel cards;   // panel that uses the CardLayout
    final static String infxtopfx = "Infix to Postfix";
    final static String evalpfx = "Evaluate Postfix";

    public void addComponentToPane(Container pane) {
        // Put the JComboBox in a JPanel to get a nicer look
        JPanel comboBoxPane = new JPanel(); // use FlowLayout
        String[] comboBoxItems = { infxtopfx, evalpfx };
        JComboBox<String> comboBox = new JComboBox<>(comboBoxItems);
        comboBox.setEditable(false);
        comboBox.addItemListener((ItemEvent event) -> {
            CardLayout cardLayout = (CardLayout) cards.getLayout();
            cardLayout.show(cards, (String) event.getItem());
        });
        comboBoxPane.add(comboBox);

        // Create the cards
        // INFIX TO POSTFIX
        JPanel cardInfToPfx = new JPanel();
        // POSTFIX EVALUATION
        JPanel cardPfxEval = new JPanel();

        // Create the panel that contains the cards
        cards = new JPanel(new CardLayout());
        cards.add(cardInfToPfx, infxtopfx);
        cards.add(cardPfxEval, evalpfx);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        // Create and setup the window
        JFrame frame = new JFrame("Infix-Postfix Utility");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create and set up the content pane
        Interface intf = new Interface();
        intf.addComponentToPane(frame.getContentPane());

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            createAndShowGUI();
        });
    }


}
