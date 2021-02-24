package java_chobo3.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesEx {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty ("url",  "jdbc:mysql://localhost:3306/mysql_study?useSSL=false");
		prop.setProperty ("user" , "user_mysql_study");
		prop.setProperty ("password" , "rootroot");
		
		try {
			prop.store(new FileOutputStream("oupput.txt"), "Properties Example");
			prop.store(new FileWriter("oupput2.properties"), "Properties Example");
			prop.storeToXML(new FileOutputStream("oupput.xml"), "Properties Example","UTF-8");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//file 로 부터 로드
		Properties loadProp = new Properties();
		Properties xmlProp = new Properties();
		try {
			loadProp.load(new FileInputStream("oupput.txt"));
			prnProperties(loadProp);
			
			xmlProp.loadFromXML(new FileInputStream("oupput.xml"));
			prnProperties(xmlProp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void prnProperties(Properties loadProp) {
		Set<Object> keys = loadProp.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " + loadProp.getProperty((String)key));
		}
	}
}
