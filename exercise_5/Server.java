package exercise_5_new;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static ServerSocket serverSocket;
	private static Socket socket = null;
	
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(9999);
			int i = 1;
			while(true) {
				socket = serverSocket.accept();
				String nameClient = "Client" + i;
				System.out.println("Kết nối với: " + nameClient);
				File file = new File(nameClient);
				if(!file.exists()) {
					file.mkdir();
				}
				ClientConnection t = new ClientConnection(socket, nameClient);
				t.start();				
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
