import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import java.io.Serializable;

/**
 * LabeledImage is used for processing the image drawn.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class LabeledImage implements Serializable {
    private double[] meanNormalizedPixel;
    private double[] pixels;
    private double label;
    private Vector features;
    private static LabeledImage labeledImageInstance;

    public static LabeledImage getInstance() {
        if (labeledImageInstance == null) {
            labeledImageInstance = new LabeledImage();
        }
        return labeledImageInstance;
    }

    public void setPixelVariables(double[] pixels){
        this.meanNormalizedPixel = meanNormalizeFeatures(pixels);
        features = Vectors.dense(meanNormalizedPixel);
        this.pixels = pixels;
    }

    public double[] getPixels() {
        return pixels;
    }

    private double[] meanNormalizeFeatures(double[] pixels) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        for (double pixel : pixels) {
            sum = sum + pixel;
            if (pixel > max) {
                max = pixel;
            }
            if (pixel < min) {
                min = pixel;
            }
        }
        double mean = sum / pixels.length;

        double[] pixelsNorm = new double[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            pixelsNorm[i] = (pixels[i] - mean) / (max - min);
        }
        return pixelsNorm;
    }

    public Vector getFeatures() {
        return features;
    }

    public double getLabel() {
        return label;
    }

    public void setLabel(double label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledImage{" + "label=" + label + '}';
    }
}
