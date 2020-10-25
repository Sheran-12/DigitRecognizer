import javax.swing.*;
import java.awt.*;

/**
 * DrawCanvas is used for setting up the layout for the canvas
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class DrawCanvas extends UIComponent {

    private static DrawArea canvas;

    public DrawCanvas() {
        canvas = new DrawArea();
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(800, 800));
        return panel;
    }

    public static DrawArea getCanvas(){
        return canvas;
    }
}
