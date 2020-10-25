/**
 * PredictionNN is used for returning the result for Neural Network.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class PredictionNN extends Prediction {

    private static PredictionNN predictionNNInstance;

    public static PredictionNN getInstance() {
        if(predictionNNInstance == null) {
            predictionNNInstance = new PredictionNN();
        }
        return predictionNNInstance;
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
