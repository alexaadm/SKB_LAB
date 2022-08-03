package readProperties;

import java.io.IOException;
import java.util.Properties;

public class Utils {

    private final static Properties prop = new Properties();

    static {
        try {
            prop.load(Utils.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

/**
 * Метод, который использует экземпляр Properties и читает из него значение по ключу из файла application.properties
 * Через этот метод получаем все данные из файла в тестовом классе
 */

    public static String getProperty (String url){
        return prop.getProperty(url);
    }
}