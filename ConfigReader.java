package utility;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found in classpath");
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) { return props.getProperty(key); }
    public static int getInt(String key) { return Integer.parseInt(get(key)); }
}
