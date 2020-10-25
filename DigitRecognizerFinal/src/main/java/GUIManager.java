import java.util.Observer;

/**
 * GUIManager is used for initializing and managing the interface
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class GUIManager {

    private final ProgressBar progressBar;
    private UI ui;
    Logger logger;

    public GUIManager() {
        progressBar = new ProgressBar();
        logger = Logger.getLogger();
    }

    public void initialize() {
        startProgressBar();
        constructUI();
        stopProgressBar();
    }

    private void constructUI() {
        ConcreteUIBuilder concreteUIBuilder = new ConcreteUIBuilder();
        ui = concreteUIBuilder.getUI();
        PredictionNN prediction = PredictionNN.getInstance();
        PredictionCNN predictionCNN = PredictionCNN.getInstance();
        Observer resultDisplay = ResultDisplay.getInstance();
        prediction.addObserver(resultDisplay);
        predictionCNN.addObserver(resultDisplay);
        logger.logMessage(AbstractLogger.INFO, "User Interface initialization completed.");
    }

    private void startProgressBar() {
        progressBar.startProgressBar();
    }

    private void stopProgressBar() {
        progressBar.stopProgressBar();
    }
}
