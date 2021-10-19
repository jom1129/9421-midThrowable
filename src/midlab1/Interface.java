package midlab1;

import jdk.jshell.execution.Util;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

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
    LinkedStack<Token> stack;
    private JPanel labelPanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JScrollPane tabelPanel;
    private JTextArea tableText = new JTextArea(20, 120);
    private JTextField input = new JTextField(TEXTAREA_COLUMNS);
    private String[] conversionType = { "Infix to Postfix Expression", "Evaluate Postfix Expression" };
    private JComboBox<String> expressionType = new JComboBox<>(conversionType);
    private JPanel expressionPanel = new JPanel();
    private JButton submit = new JButton("Submit");
    private JButton clear = new JButton("Clear");
    private JComponent[] upperPanelComponents = { new JLabel("Expression: "), input, submit };
    private JComponent[] expressionPanelComponents = { new JLabel("Expression Type: "),
            expressionType, clear };


    public Interface() {
        redirectSystemStreams();

        labelPanel.add(new JLabel("Infix-Postfix Utility"));

        for (JComponent component : upperPanelComponents) upperPanel.add(component);

        for (JComponent component : expressionPanelComponents) expressionPanel.add(component);
        expressionType.setSelectedIndex(0);

        tabelPanel = new JScrollPane(tableText);
        tabelPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabelPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableText.setEditable(false);

        submit.addActionListener((ActionEvent e) -> {
            stack = Utility.parseInput(input.getText());
            if (expressionType.getSelectedIndex() == 0) Utility.infixToPostfixTable(stack);
            else Utility.postfixEvaluateTable(stack);
            if (input.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty.");
                tableText.setText(null);
            }
        });

        clear.addActionListener((ActionEvent e) -> tableText.setText(null));



        // Utilize methods



    }

    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(() -> {
            Document doc = tableText.getDocument();
            try {
                doc.insertString(doc.getLength(), text, null);
            } catch (BadLocationException e) {

            }
            tableText.setCaretPosition(doc.getLength() - 1);
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
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

    public JScrollPane getTabelPanel() {
        return tabelPanel;
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
        frame.getContentPane().add(gui.getTabelPanel());

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
