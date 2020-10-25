import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
 * ResultDisplay is used for setting up the label which displays the result.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ResultDisplay extends UIComponent implements Observer {

    JPanel result;
    static JLabel resultLabel;
    private static ResultDisplay resultDisplayInstance;

    protected ResultDisplay() {
        result = new JPanel();
        resultLabel = new JLabel();
        result.setBackground(new Color(100,200,150));
        result.setPreferredSize(new Dimension(50, 50));
        result.setLayout(new FlowLayout());
        resultLabel.setText("");
        resultLabel.setFont(new Font("Sans Serif", Font.BOLD, 35));
        resultLabel.setSize(50, 50);
        result.add(resultLabel,BorderLayout.CENTER);
    }

    public static ResultDisplay getInstance(){
        if (resultDisplayInstance == null){
            resultDisplayInstance = new ResultDisplay();
        }
        return resultDisplayInstance;
    }

    public static JLabel getResultLabel(){
        return resultLabel;
    }

    @Override
    public JPanel setComponent(JPanel panel) {
        super.setComponent(panel);
        panel.add(result);
        return panel;
    }

    @Override
    public void update(Observable o, Object arg) {
        resultLabel.setText(String.valueOf(arg));
        resultLabel.revalidate();
    }
}
