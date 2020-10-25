import lombok.SneakyThrows;
import org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel;
import org.apache.spark.sql.SparkSession;
/**
 * NeuralNetwork is used for predicting what is drawn on the canvas
 * and follows the Strategy Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */

public class NeuralNetwork {

    private SparkSession sparkSession;
    private static MultilayerPerceptronClassificationModel model;
    private static PredictionNN prediction;
    private static ReadPropertyFile readPropertyFile;
    private static final Logger logger = Logger.getLogger();

    @SneakyThrows
    public NeuralNetwork() {
        initSparkSession();
        prediction = PredictionNN.getInstance();
        if (model == null) {
            logger.logMessage(AbstractLogger.INFO,"Loading the Neural Network from saved model.");
            readPropertyFile = new ReadPropertyFile();
            model = MultilayerPerceptronClassificationModel.load(readPropertyFile.getProperty("NN_MODEL_FILE"));
            logger.logMessage(AbstractLogger.INFO,"Loading from saved NN model is done.");
        }
    }

    private void initSparkSession() {
        if (sparkSession == null) {
            sparkSession = SparkSession.builder().master("local[*]").appName("Digit Recognizer").getOrCreate();
        }
        sparkSession.sparkContext().setCheckpointDir("checkPoint");
    }

    public static void predict() {
        LabeledImage labeledImage = LabeledImage.getInstance();
        int predict = (int) model.predict(labeledImage.getFeatures());
        labeledImage.setLabel(predict);
        prediction.setPredictionNumber(predict);
    }
}

