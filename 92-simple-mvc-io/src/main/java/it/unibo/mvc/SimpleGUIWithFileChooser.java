package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    @SuppressWarnings("Convert2Lambda") //Because it create an undesired warning 
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        final JPanel canvas2 = new JPanel();
        final JTextField text = new JTextField();
        text.setEditable(false); // Rende il JTextField non modificabile
        text.setText(controller.PathFile()); // Imposta il testo iniziale al file corrente nel controller
        final JButton browse = new JButton("Browse");
        canvas.setLayout(new BorderLayout());
        canvas2.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.add(canvas2, BorderLayout.NORTH);
        canvas2.add(text, BorderLayout.CENTER);
        canvas2.add(browse, BorderLayout.EAST);

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                final JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION -> {
                        final File selectedFile = fileChooser.getSelectedFile();
                        try {
                            controller.SetFile(selectedFile); // Imposta il file nel controller
                            text.setText(selectedFile.getAbsolutePath()); // Mostra il percorso nel JTextField
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(frame,
                                "Il file selezionato non esiste o non è un file valido.",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case JFileChooser.CANCEL_OPTION -> {
                        // Non fare nulla se l'utente annulla
                    }
                    default -> // Mostra un dialogo di errore per ogni altra situazione
                        JOptionPane.showMessageDialog(frame, 
                            "Si è verificato un errore durante la selezione del file.", 
                            "Errore", 
                            JOptionPane.ERROR_MESSAGE);
                }
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

    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
