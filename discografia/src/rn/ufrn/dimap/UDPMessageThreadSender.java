package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPMessageThreadSender extends UDPMessage implements Runnable {
	private InetAddress address;
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private int port;
			
	public UDPMessageThreadSender(String message,InetAddress address,int port) {
		
		super(message);
		this.port=port;
		
		try {
			
			this.socket = new DatagramSocket();
			setAddress(address);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}
	

	public void run() {
		
		byte[] buffer = super.getBuffer();
		int length = super.getBuffer().length;
				
		packet = new DatagramPacket(buffer,length, address,port);
		
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public InetAddress getAddress() {
		return address;
	}

	public void setAddress(InetAddress address) {
		this.address = address;
	}

	
	
}


