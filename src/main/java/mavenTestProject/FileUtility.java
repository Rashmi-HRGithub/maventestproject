package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * it is used to return the value from the property file based on key
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	
//	public String getPropertyKeyValue(String key) throws IOException
//	{
//		FileInputStream fis=new FileInputStream("./src/test/resources/data/CommonData.properties");
//		Properties pObj=new Properties();
//		pObj.load(fis);
//		String value=pObj.getProperty(key);
//		return value;
//	}

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		
		return value;
	}
		
		
	


}
