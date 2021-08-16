package exercise_2.reading;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadingConfigFile {
	
	private int size;
	private int Max_Thread;
	
	public ReadingConfigFile() {
		Properties properties = new Properties();
		InputStream inputStream = null;		
		try {
			inputStream = new FileInputStream("config.properties");
			properties.load(inputStream);
			size = Integer.parseInt(properties.getProperty("Size_Array"));
			Max_Thread = Integer.parseInt(properties.getProperty("Max_Thread"));
		} catch (Exception e) {	
			e.printStackTrace();
		} 
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getMax_Thread() {
		return Max_Thread;
	}
	
	public void setMax_Thread(int max_Thread) {
		Max_Thread = max_Thread;
	}

}
