package ex_5;

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
import java.util.Scanner;

public class Client {
	
	private static Socket socket = null;
	private static String fileName;
	private static BufferedReader stdin;
	private static PrintStream os;
//	private static NumberClient numberClient;
//	
//	public Client(NumberClient numberClient) {
//		this.numberClient = numberClient;
//	}
	
	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 9999);
			stdin = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true) {
				switch(Integer.parseInt(selectionAction())) {
					case 1:{					
						os.println(1);
						String mess = dis.readUTF();
						System.out.println("Server = " + mess);
						if(mess.equalsIgnoreCase("ok")) {
							System.out.println("-------------------Client send File ----------------");
							System.out.println("scanf file: ");
							sendFile();
						}else {
							System.out.println("Don't sent to Server");
						}						
						break;
					}
					case 2:{	
						os.println(2);
						String mess = dis.readUTF();
						System.out.println("Server = " + mess);
						if(mess.equalsIgnoreCase("ok")) {
							System.out.println("-------------------Client get file from Server----------------");
							System.out.println("scanf file: ");
							fileName = stdin.readLine();
							os.println(fileName);
							getFile(fileName);
						}else {
							System.out.println("Don't get from server");
						}					
						break;
					}
					default:{
						System.out.println("scanf again.");
					}
				}
			}			
		} catch (Exception e) {
			System.out.println("Can't connect ...");
			System.exit(1);
		}
				
	}

	public static String selectionAction() throws IOException {
		System.out.println("1. Send file to Server");
		System.out.println("2. Get file from Server");
		System.out.println("Do you choose ???");
		return stdin.readLine();
	}
	
	public static void sendFile() {
		try {
			fileName = stdin.readLine();	
			File file = new File(fileName);
			if(file.exists()) {	
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(file.getName());
				dos.flush();
//				String mess = dis.readUTF();
//				System.out.println("Server: " + mess);
				OutputStream out = socket.getOutputStream();
				FileInputStream inSend = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int count;
				while((count=inSend.read(buffer)) >= 0) {
					out.write(buffer, 0, count);
				}
				dis.close();
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
//			outFile.close();
//			in.close();
//			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
