import javax.swing.*;
import java.awt.*;

/**
 * BottomPanelConcreteDecorator is used for building the bottom panel
 * for displaying the Logger messages and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class BottomPanelConcreteDecorator extends PanelDecorator {

    private JPanel bottomPanel;

    public BottomPanelConcreteDecorator(UIComponent uiComponent){
        bottomPanel = new JPanel();
        bottomPanel = uiComponent.setComponent(bottomPanel);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setPreferredSize(new Dimension(800,100));
    }

    @Override
    public JPanel decoratePanel() {
        return bottomPanel;
    }
}
