package br.com.objective.jeecourse.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.objective.jeecourse.client.proxy.OperationDto;
import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.SimpleCalculatorFactory;

public class SocketServer {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Calculator calculator = new SimpleCalculatorFactory().newCalculator();
		String result = null;
		ServerSocket serverSocket = new ServerSocket(1234);
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();
		
		while (socket.isConnected()) {
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			OperationDto dto = (OperationDto) objectInputStream.readObject();
			
			switch (dto.getOperation()) {
			case ADD:
				result = calculator.add(dto.getLeft(), dto.getRight());
				break;
				
			case SUBTRACT:
				result = calculator.subtract(dto.getLeft(), dto.getRight());
				break;
	
			case COMPARE:
				result = String.valueOf(calculator.compare(dto.getLeft(), dto.getRight()));
				break;
				
			default:
				break;
			}
			
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(result);
			outputStream.flush();
		}
		
		socket.close();
		serverSocket.close();
	}

}
