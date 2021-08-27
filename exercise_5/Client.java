package exercise_5_new;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	
	private static Socket socket = null;
	private static String fileName;
	private static BufferedReader stdin;
	private static PrintStream os;
	
	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 9999);
			stdin = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintStream(socket.getOutputStream());
			while(true) {
				switch(Integer.parseInt(selectionAction())) {
					case 1:{
						os.println(1);
						sendFile();
						break;
					}
					case 2:{
						os.println(2);
						System.out.println("-------------------Client Nhận File Từ Server----------------");
						System.out.println("Nhập tên file: ");
						fileName = stdin.readLine();
						os.println(fileName);
						getFile(fileName);
						break;
					}
					default:{
						System.out.println("Nhập lại.");
						break;
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("Không thể kết nối đến server ...");
			System.exit(1);
		}
				
	}

	public static String selectionAction() throws IOException {
		System.out.println("1. Gửi File lên Server");
		System.out.println("2. Nhận File từ Server");
		System.out.println("Bạn muốn làm gì ???");
		return stdin.readLine();
	}
	
	public static void sendFile() {
		System.out.println("-------------------Client Gửi File Lên Server----------------");
		try {
			fileName = stdin.readLine();			
			File file = new File(fileName);
			if(file.exists()) {	
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(file.getName());
				dos.flush();
				OutputStream out = socket.getOutputStream();
				FileInputStream inSend = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int count;
				while((count=inSend.read(buffer)) >= 0) {
					out.write(buffer, 0, count);
				}
//				dos.close();
//				out.close();
//				inSend.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFile(String fileName) {
		try {			
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			fileName = dis.readUTF();
			InputStream in = socket.getInputStream();
			FileOutputStream outFile = new FileOutputStream(("Client//" + fileName));
			
			byte[] buffer = new byte[1024];
			int count;
			while ((count = in.read(buffer)) >= 0) {
				outFile.write(buffer, 0, count);
			}
//			dis.close();
//			in.close();
//			outFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
