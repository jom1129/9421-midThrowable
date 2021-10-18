package midlab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.PortUnreachableException;

/*
    GUI CLASS: @Kurt
        You are free to contribute here, however.
 */
public class Interface {
    /*
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


     */
    private static final int TEXTAREA_COLUMNS = 20;
    private JPanel labelPanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JTextField input = new JTextField(TEXTAREA_COLUMNS);
    private JLabel expressionType = new JLabel("Postfix.");
    private JPanel expressionPanel = new JPanel();
    private JButton submit = new JButton("Submit");
    private JComponent[] upperPanelComponents = { new JLabel("Expression: "), input };
    private JComponent[] expressionPanelComponents = { new JLabel("Expression Type: "),
            expressionType, submit};

    public Interface() {
        labelPanel.add(new JLabel("Infix-Postfix Utility"));
        for (JComponent component : upperPanelComponents) upperPanel.add(component);
        for (JComponent component : expressionPanelComponents) expressionPanel.add(component);
        submit.addActionListener((ActionEvent e) -> expressionType.setText(input.getText()));
    }

    public JPanel getLabelPanel() {
        return labelPanel;
    }

    public JPanel getUpperPanel() {
        return upperPanel;
    }

    public JPanel getExpressionPanel() {
        return expressionPanel;
    }

    private static void createAndShowGUI() {
        Interface gui = new Interface();
        JFrame frame = new JFrame();
        // Use the Box Layout for the Content Pane
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add the panels
        frame.getContentPane().add(gui.getLabelPanel());
        frame.getContentPane().add(gui.getUpperPanel());
        frame.getContentPane().add(gui.getExpressionPanel());

        // Display the window
        frame.pack();
        frame.setTitle("Infix-Postfix Utility");
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Silence the compiler
            }
            createAndShowGUI();
        });
    }

}
