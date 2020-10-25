import lombok.SneakyThrows;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.factory.Nd4j;
import java.io.File;
import java.io.IOException;

/**
 * ConvolutionalNeuralNetwork is used for predicting what is drawn on the canvas
 * and follows the Strategy Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ConvolutionalNeuralNetwork {

    private static MultiLayerNetwork preTrainedModel;
    private static PredictionCNN prediction;
    private static ReadPropertyFile readPropertyFile;
    private static File modelFile;
    private static final Logger logger = Logger.getLogger();

    @SneakyThrows
    public ConvolutionalNeuralNetwork() {
        logger.logMessage(AbstractLogger.INFO,"Loading the Convolutional Neural Network from saved model.");
        prediction = prediction.getInstance();
        try {
            readPropertyFile = new ReadPropertyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelFile = new File(readPropertyFile.getProperty("CNN_MODEL_FILE"));
        try {
            preTrainedModel = ModelSerializer.restoreMultiLayerNetwork(modelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.logMessage(AbstractLogger.INFO,"Loading from saved CNN model is done.");
    }

    public static void predict() {
        LabeledImage labeledImage = LabeledImage.getInstance();
        double[] pixels = labeledImage.getPixels();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = pixels[i] / 255d;
        }
        int[] predict = preTrainedModel.predict(Nd4j.create(pixels));
        prediction.setPredictionNumber(predict[0]);
    }
}
