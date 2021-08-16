package exercise_2.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import exercise_2.reading.ReadingConfigFile;

public class WritingInputFile {
	
	public void writeToFileInput(String filePath) {
		ReadingConfigFile config = new ReadingConfigFile();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			System.out.println(config.getSize());
			fw = new FileWriter(new File(filePath));
			bw = new BufferedWriter(fw);
			for(int i = 0; i < config.getSize(); i++) {
				int b = new Random().nextInt(config.getSize()) + 1;
				bw.write(b + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(bw != null) {
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
