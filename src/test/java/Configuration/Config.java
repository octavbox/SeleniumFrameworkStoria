package Configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    static Properties props;
    static String projectPath = System.getProperty("user.dir");

    public String getProperty(String key) {
        props = new Properties();
        try {
            InputStream input = new FileInputStream(projectPath + "/src/test/java/Configuration/config.properties");
            props.load(input);
        } catch (Exception e) {
            e.getMessage();
        }
        return props.getProperty(key);
    }
}
