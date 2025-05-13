package toolsConfig;

import java.io.InputStream;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigTools {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigTools.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("File 'config.properties' not found");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load 'config.properties' file", e);
        }
    }


    public CharSequence getProperty(String key) {
        return properties.getProperty(key);
    }
}