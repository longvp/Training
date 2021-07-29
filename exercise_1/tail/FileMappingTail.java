package exercise_1.tail;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import exercise_1.intf.TailAlgoIF;

public class FileMappingTail implements TailAlgoIF {

	@Override
	public String doTail(File filePath, int n) {
		FileInputStream fis = null;
		FileChannel fc = null;
		ByteBuffer buffer = null;
		try {
			fis = new FileInputStream(filePath);
			fc = fis.getChannel();
			buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			buffer.position((int) fc.size());
			int lines = 0;
			StringBuilder sb = new StringBuilder();
			for(long i = fc.size() - 1; i >= 0; i--) {
				char c = (char)buffer.get((int) i);
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
			try {
				if(fis != null) {
					fis.close();
				}
				if(fc != null) {
					fc.close();
				}
			} catch (Exception e2) {
				
			}
		}
	}

}
