import javax.swing.*;

/**
 * UIComponent is used for setting up the panel.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public abstract class UIComponent{

    public JPanel setComponent(JPanel panel) {
        panel.setLayout(null);
        return panel;
    }
}
