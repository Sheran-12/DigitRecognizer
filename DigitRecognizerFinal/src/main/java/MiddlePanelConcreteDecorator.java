import javax.swing.*;
import java.awt.*;

/**
 * MiddlePanelConcreteDecorator is used for building the middle canvas for drawing.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class MiddlePanelConcreteDecorator extends PanelDecorator {

    private JPanel middlePanel;

    public MiddlePanelConcreteDecorator(UIComponent uiComponent){
        middlePanel = new JPanel();
        middlePanel = uiComponent.setComponent(middlePanel);
        middlePanel.setPreferredSize(new Dimension(800,400));
    }

    @Override
    public JPanel decoratePanel() {
        return middlePanel;
    }
}
