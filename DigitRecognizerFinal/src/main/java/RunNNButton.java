import javax.swing.*;
import java.awt.*;

/**
 * RunCNNButton is used for setting the button for recognizing NN
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class RunNNButton extends UIComponent{

    private JButton button;
    private static final Logger logger = Logger.getLogger();

    public RunNNButton() {
        button = new JButton();
        button.setText("Recognize using NN");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(new Color( 250,150,150));
        button.setPreferredSize(new Dimension(250, 50));
        button.addActionListener(e -> {
            logger.logMessage(AbstractLogger.INFO, "Recognizing digit using NN.");
            RecognizeNN recognize = new RecognizeNN();
            recognize.recognizeNN();
        });
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(button);
        return panel;
    }
}
