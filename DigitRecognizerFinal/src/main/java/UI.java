import javax.swing.*;
import java.awt.*;
import java.util.Observer;
/**
 * UI is used for initializing the interface.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class UI {

    public UI () {
        JFrame mainFrame = new JFrame("Digit Recognizer");

        UIComponent about = new RunAboutButton();
        UIComponent runNN = new RunNNButton();
        UIComponent runCNN = new RunCNNButton();
        UIComponent clear = new ClearButton();
        UIComponent result = ResultDisplay.getInstance();
        UIComponent canvas = new DrawCanvas();
        UIComponent console = new ConsoleArea();

        JPanel panel1 = new TopPanelConcreteDecorator(about, runNN, runCNN, clear, result).decoratePanel();
        JPanel panel2 = new MiddlePanelConcreteDecorator(canvas).decoratePanel();
        JPanel panel3 = new BottomPanelConcreteDecorator(console).decoratePanel();

        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
