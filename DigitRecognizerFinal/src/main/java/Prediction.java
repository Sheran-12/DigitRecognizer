import java.util.Observable;

/**
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public abstract class Prediction extends Observable  {
    protected int predictionNumber;
    public abstract int getPredictionNumber();
}
