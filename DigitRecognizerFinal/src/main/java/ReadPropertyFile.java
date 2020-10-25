import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ReadPropertyFile is used for fetching constants such as paths,
 * environment variables or constant values from the config.properties
 * file.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public class ReadPropertyFile {

    private Properties properties;
    private FileReader reader;
    private File configFile;

    public ReadPropertyFile() throws IOException {
        configFile = new File("src/main/java/config.properties");
        reader = new FileReader(configFile);
        properties = new Properties();
        properties.load(reader);
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
