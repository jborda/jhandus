package br.com.objective.jeecourse.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;

import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.SimpleCalculatorFactory;

public class SocketThread extends Thread {

	private final Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private long id;
	
	public SocketThread(Socket socket) throws IOException {
		this.socket = socket;
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		id = Calendar.getInstance().getTimeInMillis();
	}
	
	@Override
	public void run() {

		Calculator calculator = new SimpleCalculatorFactory().newCalculator();
		String result = null;
		
		while (true) {
			result = execute(calculator, result);
		}
	}

	private String execute(Calculator calculator, String result) {
		
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			OperationDto dto = (OperationDto) objectInputStream.readObject();
			System.out.println("[" +id+ "] nova operação: " + dto.getOperation());
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
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
			objectOutputStream.writeObject(result);
			outputStream.flush();
		} catch (Exception e) {
			this.interrupt();
		}
		
		return result;
	}
	@Override
	public void interrupt() {
		if (!socket.isClosed())
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		super.interrupt();
	}

}
