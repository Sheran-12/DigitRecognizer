/**
 * PredictionCNN is used for returning the result for Convulational Neural Network.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class PredictionCNN extends Prediction {

    private static PredictionCNN predictionCNNInstance;

    public static PredictionCNN getInstance() {
        if(predictionCNNInstance == null) {
            predictionCNNInstance = new PredictionCNN();
        }
        return predictionCNNInstance;
    }

    public void setPredictionNumber(int predictionNumber) {
        this.predictionNumber = predictionNumber;
        setChanged();
        notifyObservers(this.predictionNumber);
    }

    public int getPredictionNumber() {
        return predictionNumber;
    }
}
