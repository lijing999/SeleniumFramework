package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/28.
 */
public class EnvProperties {
    public static Properties getProperties(String filepath) throws FileNotFoundException, IOException {

        FileInputStream file=new FileInputStream(filepath);
        Properties prop=new Properties();
        prop.load(file);
        return prop;
    }
}
