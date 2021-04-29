package Moduls.FilesReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * how to read configuration data from properties8888 file
 */
public class PropertyFileReader {

	public static String[] propertiesFileReader(String [] data)
	{

		String [] datafile =new String[data.length];
		Properties property = new Properties();

				
						 try {
								InputStream input = new FileInputStream("src\\test\\resources\\DataDriven\\configurations.properties");
							
									property.load(input);
						 }
							catch (IOException e) { 
								e.printStackTrace();


								}
						 
						 
						 
						 for(int i = 0 ; i < data.length ; i++) {
							 
							 
							 datafile[i] = property.getProperty(data[i]);
							
							}
						 
		return datafile;
	}
}
