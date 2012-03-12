package rn.ufrn.dimap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessage{

	private  DatagramSocket socket = null;
	private  DatagramPacket request = null;
	private byte[] buffer;
	private String message;
	
	
	public UDPMessage(DatagramSocket socket) {
		super();
		this.socket = socket;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String sender) {
		this.message=sender;
	}
		
	public void closeSocket(){
		this.socket.close();
	}

	public DatagramSocket getSocket() {
		return socket;
	}


	public DatagramPacket getRequest() {
		return request;
	}

	
	public byte[] getBuffer() {
		return buffer;
	}

	
	
}
