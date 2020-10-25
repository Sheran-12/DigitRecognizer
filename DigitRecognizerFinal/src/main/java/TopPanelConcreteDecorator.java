import javax.swing.*;
import java.awt.*;

/**
 * TopPanelConcreteDecorator is used for building the top canvas for drawing.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class TopPanelConcreteDecorator extends PanelDecorator {

    private JPanel topPanel;

    public TopPanelConcreteDecorator(UIComponent ...uiComponents) {
        topPanel = new JPanel();
        for (UIComponent uiComponent : uiComponents) {
            topPanel = uiComponent.setComponent(topPanel);
        }
        topPanel.setBackground(new Color(100,200,250));
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(800,100));
    }

    @Override
    public JPanel decoratePanel() {
        return topPanel;
    }
}
