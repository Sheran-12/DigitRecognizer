import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * RunAboutButton is used for initializing the About button
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class RunAboutButton extends UIComponent {

    private JButton button;
    private static final Logger logger = Logger.getLogger();

    public RunAboutButton() {
        button = new JButton();
        button.setText("About");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(new Color( 250,150,150));
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            logger.logMessage(AbstractLogger.INFO, "Displaying about information.");
            JFrame dialogBoxFrame = new JFrame("Dialog Box");
            JDialog dialog = new JDialog(dialogBoxFrame, "About");
            dialog.setLayout(new BorderLayout());
            JLabel label = new JLabel("This is a Digit Recognizer project developed by Sukhpreet, Sheran and Khushboo.");
            label.setBounds(20,20,400,100);
            dialog.add(label, BorderLayout.CENTER);
            dialog.setSize(400,100);
            dialog.setVisible(true);
        });
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(button);
        return panel;
    }
}

