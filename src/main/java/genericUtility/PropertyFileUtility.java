package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of generic methods related to propertyfile
 * @author Charitha M
 */
public class PropertyFileUtility {
	/**
	 * This method will be read data from propertyfile and return the value to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;
	
}
}
