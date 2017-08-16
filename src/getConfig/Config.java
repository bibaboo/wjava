package getConfig;

import java.io.IOException;
import java.util.Properties;

public final class Config {

	private static final Properties prop = new Properties();
	
	static {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            prop.load(loader.getResourceAsStream("getConfig/config.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

	public static String getProperty(String key){
		return prop.getProperty(key);

	}

}
