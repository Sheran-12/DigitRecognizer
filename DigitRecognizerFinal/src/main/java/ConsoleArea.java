import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * ConsoleArea is used for displaying the log messages at the bottom of the Ui
 * and it is the Observer to the Logger.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ConsoleArea extends UIComponent {

    JTextArea textArea;
    JScrollPane scrollPane;

    public ConsoleArea() {
        textArea = new JTextArea();
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(800, 100));
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(scrollPane);
        return panel;
    }
}
