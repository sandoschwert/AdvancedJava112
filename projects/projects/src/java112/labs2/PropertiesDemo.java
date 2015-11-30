package java112.labs2;

import java.io.*;
import java.util.*; //holds collections like arraylists and maps

public class PropertiesDemo {

	public static void main(String[] args) {
	
		PropertiesDemo demo = new PropertiesDemo();
		demo.run();
		
	}
	
	//will demonstrate loading properties from a file
	public void run() {
		//this is a fancy collection that holds key/value pairs
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/demo.properties"));
			System.out.println("Author: " + properties.getProperty("author"));
			
			for (String key: properties.stringPropertyNames()) {
					String value = properties.getProperty(key);
					System.out.println(key + " => " + value);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
