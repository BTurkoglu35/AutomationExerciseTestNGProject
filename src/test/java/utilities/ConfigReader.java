package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {//Her methoddan once calisir
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static String getProperty(String key){
  /*
  Test methodundan yolladigimiz string key degerini alip properties clasiindan
  get properties methodunu kullanarak bu key'e ait value'yu bize getirir.
   */
        return properties.getProperty(key);
    }
}
