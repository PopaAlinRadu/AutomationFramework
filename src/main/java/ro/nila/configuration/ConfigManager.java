package ro.nila.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties configProperties;

    public static void loadConfiguration() throws IOException {

        System.out.println("    Loading---> configuration.properties");

        configProperties = getConfigProperties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties")) {
            configProperties.load(fileInputStream);
            System.out.println("configuration.properties <----Loaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Properties getConfigProperties() {
        if (configProperties == null) {
            configProperties = new Properties();
        }
        return configProperties;
    }
}
