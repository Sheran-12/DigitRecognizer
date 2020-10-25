import javax.swing.*;
import java.io.*;

/**
 * CustomOutputStream is the target for routing all standare console output messages to Console Area
 *
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class CustomOutputStream extends OutputStream {

    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.update(textArea.getGraphics());
    }
}