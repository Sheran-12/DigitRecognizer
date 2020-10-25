import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * ConcreteUIBuilder is used for setting up the look and feel and initializing everything before everything starts
 * and follows the Decorator Design pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ConcreteUIBuilder implements UIBuilder {

    private ReadPropertyFile readPropertyFile;

    public void setPreferences() {
        changeUILookAndFeel();
//        setHadoopHomeEnvironmentVariable();
        initializeNeuralNetworks();
    }

    private void initializeNeuralNetworks() {
        new NeuralNetwork();
        new ConvolutionalNeuralNetwork();
    }

    private void setHadoopHomeEnvironmentVariable() {
        try {
            readPropertyFile = new ReadPropertyFile();
            String hadoopEnv = readPropertyFile.getProperty("HADOOP_ENV");
            String hadoopFilePath = readPropertyFile.getProperty("HADOOP_PATH");
            String processEnvClass = readPropertyFile.getProperty("PROCESS_ENV_CLASS");
            String envField = readPropertyFile.getProperty("ENV_FIELD");
            String caseInsensitiveEnvField = readPropertyFile.getProperty("CASE_INSENSITIVE_ENV_FIELD");
            HashMap<String, String> hadoopEnvSetUp = new HashMap<String, String>() {{
                put(hadoopEnv, new File(hadoopFilePath).getAbsolutePath());
            }};

            Field theEnvironmentField = Class.forName(processEnvClass).getDeclaredField(envField);
            theEnvironmentField.setAccessible(true);
            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.clear();
            env.putAll(hadoopEnvSetUp);

            Field theCaseInsensitiveEnvironmentField = Class.forName(processEnvClass).getDeclaredField(caseInsensitiveEnvField);
            theCaseInsensitiveEnvironmentField.setAccessible(true);
            Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
            cienv.clear();
            cienv.putAll(hadoopEnvSetUp);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeUILookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 18)));
            UIManager.put("ProgressBar.font", new FontUIResource(new Font("Dialog", Font.BOLD, 18)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UI getUI() {
        setPreferences();
        return new UI();
    }
}