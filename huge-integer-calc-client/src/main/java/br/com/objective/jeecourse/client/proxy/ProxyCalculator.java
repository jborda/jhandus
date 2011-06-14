package br.com.objective.jeecourse.client.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.objective.jeecourse.client.proxy.OperationDto.Operation;
import br.com.objective.jeecourse.core.Calculator;

public class ProxyCalculator implements Calculator {
	
	private Socket socket;
	private String host;
	private int port;

	public ProxyCalculator(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public String add(String left, String right) {
		OperationDto dto = new OperationDto(Operation.ADD, left, right);
		return sendOperation(dto);
	}

	@Override
	public String subtract(String left, String right) {
		OperationDto dto = new OperationDto(Operation.SUBTRACT, left, right);
		return sendOperation(dto);
	}

	@Override
	public int compare(String left, String right) {
		OperationDto dto = new OperationDto(Operation.COMPARE, left, right);
		return Integer.parseInt(sendOperation(dto));
	}
	
	private String sendOperation(OperationDto dto) {
		String result = null;
		
		try {
			OutputStream outputStream = getSocket().getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(dto);
			
			outputStream.flush();
			
			ObjectInputStream inputStream = new ObjectInputStream(getSocket().getInputStream());
			result = (String) inputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private Socket getSocket() throws UnknownHostException, IOException {
		if (socket == null || socket.isClosed())
			socket = new Socket(host, port);
		
		return socket;
	}

}
