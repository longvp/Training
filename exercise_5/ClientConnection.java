package ex_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

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
			Scanner scanner = new Scanner(System.in);
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			in = new BufferedReader(isr);
			String clientSelection;
			while((clientSelection = in.readLine()) != null) {
				switch(clientSelection){
					case "1":{
						System.out.println("Client send file ...");
						System.out.println("ok Or no: ");
						String mess = "";
						mess = scanner.nextLine();
						dos.writeUTF(mess);
						dos.flush();
						if(mess.equals("ok")) {
							getFile();
						}
						break;
					}
					case "2":{
						System.out.println("Client get file ...");
						System.out.println("ok Or no: ");
						String mess = "";
						mess = scanner.nextLine();
						dos.writeUTF(mess);
						dos.flush();
						if(mess.equalsIgnoreCase("ok")) {
							String fileName;
							while((fileName = in.readLine()) != null) {
								sendFile(fileName);
							}
						}
						break;
					}					
					default:{
						System.out.println("Scanf again ...");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendFile(String fileName) {
		System.out.println("Server send file ");
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
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getFile() {
		try {				
			File serverFolder = new File("Server");
			if(!serverFolder.exists()) {
				serverFolder.mkdir();
			}
			File[] listFile = null;
			if(serverFolder.isDirectory()) {
				listFile = serverFolder.listFiles();	
			}
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fileName = dis.readUTF();
			InputStream in = socket.getInputStream();
			if(listFile != null) {
				int dem = 0;
				for(int i = 0; i < listFile.length; i++) {
					if(listFile[i].getName().equals(fileName)) {
						dem++;
						break;
					}
				}
				if(dem > 0) {
//					dos.writeUTF("File exist SERVER.");
//					dos.flush();
				}else {
					FileOutputStream outFile = new FileOutputStream(("Server//" + fileName));
					
					byte[] buffer = new byte[1024];
					int count;
					while ((count = in.read(buffer)) >= 0) {
						outFile.write(buffer, 0, count);
					}
				}
			}else {
				FileOutputStream outFile = new FileOutputStream(("Server//" + fileName));
				
				byte[] buffer = new byte[1024];
				int count;
				while ((count = in.read(buffer)) >= 0) {
					outFile.write(buffer, 0, count);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
