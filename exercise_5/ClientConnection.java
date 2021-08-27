package exercise_5_new;

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
import java.net.Socket;

public class ClientConnection extends Thread{
	
	private Socket socket;
	private String nameClient;
	private BufferedReader in = null;
	
	public ClientConnection(Socket socket, String nameClient) {
		this.socket = socket;
		this.nameClient = nameClient;
	}
	
	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			in = new BufferedReader(isr);
			String clientSelection;
			while((clientSelection = in.readLine()) != null) {
				switch(clientSelection){
					case "1":{
						getFile();
						break;
					}
					case "2":{
						String fileName;
						while((fileName = in.readLine()) != null) {
							sendFile(fileName);
						}
						break;
					}					
					default:{
						System.out.println("Nhập lại ...");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendFile(String fileName) {
		System.out.println("Server send file TO " + nameClient);
		try {
			File file = new File("Server//" + fileName);
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
	
	public void getFile() {
		try {			
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fileName = dis.readUTF();
			InputStream in = socket.getInputStream();
			FileOutputStream outFile = new FileOutputStream(("Server//" + fileName));
			
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
