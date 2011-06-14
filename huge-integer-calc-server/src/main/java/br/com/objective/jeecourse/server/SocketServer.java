package br.com.objective.jeecourse.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ServerSocket serverSocket = new ServerSocket(1234);		
		while (true) {
			new SocketThread(serverSocket.accept()).start();
		}
	}

}
