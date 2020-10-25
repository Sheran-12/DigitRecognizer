import javax.swing.*;

/**
 * PanelDecorator is used for initializing the Panel.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public abstract class PanelDecorator extends UIComponent {
    public abstract JPanel decoratePanel();
}
