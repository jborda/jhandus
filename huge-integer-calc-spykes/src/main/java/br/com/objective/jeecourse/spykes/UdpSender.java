package br.com.objective.jeecourse.spykes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(1826);

		String data = "Hellow world!";
		
		DatagramPacket packet = new DatagramPacket(
				data.getBytes(), 
				data.getBytes().length, 
				new InetSocketAddress("localhost", 1825));

		socket.send(packet);
	}
}
