package br.com.objective.jeecourse.spykes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(1825);

		byte[] buffer = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		
		while(true) {
			socket.receive(packet);
			String data = new String(packet.getData(), 0, packet.getLength());
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(packet.getAddress().getHostAddress());
			System.out.println(data);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		}
		
	}
}
