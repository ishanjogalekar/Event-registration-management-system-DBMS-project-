//Read Properties from properties file
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.Properties;

public class PropertiesReader {

    public String getProperty(String key) {
        String value = "";
        Properties SystemProperties = new Properties();
        try {
            InputStream istream = this.getClass()
                    .getResourceAsStream("/utils/application.properties");
            if (istream != null) {
                SystemProperties.load(istream);
                istream.close();
            }
            value = (String) SystemProperties.get(key);

        } catch (IOException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println("Exception in reading property file " + e);
        }
        return value;
    }
}
