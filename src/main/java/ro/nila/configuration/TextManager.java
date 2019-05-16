package ro.nila.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TextManager {

    private static Properties textProperties;

    public static void loadConfiguration() throws IOException {
        System.out.println("    Loading---> configuration.properties");

        textProperties = getTextProperties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\text.properties")) {
            textProperties.load(fileInputStream);
            System.out.println("text.properties <----Loaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Properties getTextProperties() {
        if (textProperties == null) {
            textProperties = new Properties();
        }
        return textProperties;
    }
}
