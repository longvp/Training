package exercise_test.read;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import exercise_test.intf.ReadFile;

public class ReadUsingNIO implements ReadFile {

	@Override
	public List<String> readFile(File filePath) {	
		try {
			Path path = Paths.get(filePath.getName());
			List<String> list = Files.readAllLines(path);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
