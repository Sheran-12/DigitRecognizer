import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * RecognizeNN is responsible for scale and position the CNN result.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class RecognizeNN {

    public void recognizeNN(){
        Image drawImage = DrawArea.getImage();
        BufferedImage sbi = toBufferedImage(drawImage);
        Image scaled = scale(sbi);
        BufferedImage scaledBuffered = toBufferedImage(scaled);
        double[] scaledPixels = transformImageToOneDimensionalVector(scaledBuffered);
        LabeledImage labeledImage = LabeledImage.getInstance();
        labeledImage.setLabel(0);
        labeledImage.setPixelVariables(scaledPixels);
        NeuralNetwork.predict();
    }

    private static BufferedImage scale(BufferedImage imageToScale) {
        ResampleOp resizeOp = new ResampleOp(28, 28);
        resizeOp.setFilter(ResampleFilters.getLanczos3Filter());
        BufferedImage filter = resizeOp.filter(imageToScale, null);
        return filter;
    }

    private static BufferedImage toBufferedImage(Image img) {
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    private static double[] transformImageToOneDimensionalVector(BufferedImage img) {
        double[] imageGray = new double[28 * 28];
        int w = img.getWidth();
        int h = img.getHeight();
        int index = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color color = new Color(img.getRGB(j, i), true);
                int red = (color.getRed());
                int green = (color.getGreen());
                int blue = (color.getBlue());
                double v = 255 - (red + green + blue) / 3d;
                imageGray[index] = v;
                index++;
            }
        }
        return imageGray;
    }
}
