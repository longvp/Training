package exercise_1.tail;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import exercise_1.intf.TailAlgoIF;

public class NormalTail implements TailAlgoIF{

	@Override
	public String doTail(File filePath, int n) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(filePath, "r");
			int lines = 0;
			StringBuilder sb = new StringBuilder();
			long lengthFile = raf.length();
			for(long seek = lengthFile-1; seek >= 0; seek--) {
				raf.seek(seek);
				char c = (char) raf.read();
				if(c == '\n') {
					lines++;
					if(lines == n) {
						break;
					}
				}
				sb.append(c);
			}
			sb.reverse();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
