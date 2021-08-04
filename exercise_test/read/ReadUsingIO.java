package exercise_test.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exercise_test.intf.ReadFile;

public class ReadUsingIO implements ReadFile{

//	@Override
//	public String doTail(File filePath, int n) {
//		RandomAccessFile raf = null;
//		try {
//			raf = new RandomAccessFile(filePath, "r");
//			int lines = 0;
//			StringBuilder sb = new StringBuilder();
//			long lengthFile = raf.length();
//			for(long seek = lengthFile-1; seek >= 0; seek--) {
//				raf.seek(seek);
//				char c = (char) raf.read();
//				if(c == '\n') {
//					lines++;
//					if(lines == n) {
//						break;
//					}
//				}
//				sb.append(c);
//			}
//			sb.reverse();
//			return sb.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}finally {
//			if(raf != null) {
//				try {
//					raf.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	
	@Override
	public List<String> readFile(File filePath) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			List<String> list = new ArrayList<String>();
			String line;
			while((line = br.readLine()) != null) {
				list.add(line);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	

}
