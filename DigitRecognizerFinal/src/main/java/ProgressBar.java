import javax.swing.*;
import java.awt.*;

/**
 * ProgressBar is used for setting up the progress bar.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ProgressBar {

    private JFrame progressBarFrame;
    private JProgressBar progressBar;

    public ProgressBar() {
        this.progressBarFrame = new JFrame();
        this.progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    }

    public void startProgressBar() {
        SwingUtilities.invokeLater(() -> {
            progressBarFrame.setLocationRelativeTo(null);
            progressBarFrame.setUndecorated(true);
            progressBar.setString("Collecting data this make take several seconds!");
            progressBar.setStringPainted(true);
            progressBar.setIndeterminate(true);
            progressBar.setVisible(true);
            progressBarFrame.add(progressBar, BorderLayout.NORTH);
            progressBarFrame.pack();
            progressBarFrame.setVisible(true);
            progressBarFrame.repaint();
        });
    }

    public void stopProgressBar() {
        progressBar.setVisible(false);
        progressBarFrame.dispose();
    }
}
