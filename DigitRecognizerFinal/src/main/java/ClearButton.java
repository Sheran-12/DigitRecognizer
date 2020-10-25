import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClearButton is used for clearing the canvas
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ClearButton extends UIComponent{

    private JButton button;
    private static final Logger logger = Logger.getLogger();

    public ClearButton() {
        button = new JButton();
        button.setText("Clear");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(new Color( 250,150,150));
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.logMessage(AbstractLogger.INFO, "Result cleared.");
                JLabel result = ResultDisplay.getResultLabel();
                result.setText("");
                result.revalidate();
                DrawArea drawCanvas = DrawCanvas.getCanvas();
                drawCanvas.setImage(null);
                drawCanvas.repaint();
                drawCanvas.updateUI();
            }
        });
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(button);
        return panel;
    }
}
