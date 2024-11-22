package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int INGRANDIMENTO = 5;
    /**
     * @param controller the controller to manage the logic
     */
    public SimpleGUI(final Controller controller) {
        final JPanel canvas = new JPanel();
        final JPanel canvas2 = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setLayout(new BorderLayout());
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvas2, BorderLayout.SOUTH);
        canvas2.add(print, BorderLayout.EAST);
        canvas2.add(showHistory, BorderLayout.WEST);
        print.addActionListener((ActionEvent e) -> {
            final String text = textField.getText();
            if (!text.isBlank()) {
                controller.setNextString(text);
                controller.printCurrentString();
                textField.setText(""); // Clear the text field after printing
            }
        });
        showHistory.addActionListener((ActionEvent e) -> {
            textArea.setText(""); // Clear the text area to avoid duplicates
            final List<String> history = controller.getPrintedString();
            for (final String string : history) {
                textArea.append(string + " ");
            }
        });
    }
    /**
     * Display the GUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / INGRANDIMENTO, sh / INGRANDIMENTO);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
