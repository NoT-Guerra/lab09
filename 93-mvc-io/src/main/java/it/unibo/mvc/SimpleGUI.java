package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    int PROPORTION = 5 ;

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        final JPanel canvas2 = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setLayout(new BorderLayout());
        canvas.add(textField,BorderLayout.NORTH);
        canvas.add(textArea,BorderLayout.CENTER);
        canvas.add(canvas2,BorderLayout.SOUTH);
        canvas2.add(print,BorderLayout.EAST);
        canvas2.add(showHistory,BorderLayout.WEST);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

public static void main(String[] args) {
    new SimpleGUI().display();
}
}
