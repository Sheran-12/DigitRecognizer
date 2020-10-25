import javax.swing.*;
import java.awt.*;

/**
 * RunCNNButton is used for setting the button for recognizing CNN
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class RunCNNButton extends UIComponent {

    private JButton button;
    private static final Logger logger = Logger.getLogger();

    public RunCNNButton() {
        button = new JButton();
        button.setText("Recognize using CNN");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(new Color( 250,150,150));
        button.setPreferredSize(new Dimension(250, 50));
        button.addActionListener(e -> {
            logger.logMessage(AbstractLogger.INFO, "Recognizing digit using CNN.");
            RecognizeCNN recognize = new RecognizeCNN();
            recognize.recognizeCNN();
        });
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(button);
        return panel;
    }
}