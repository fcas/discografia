package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class UDPSendMessage {
	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private InetAddress serverAdress = null;
	private UDPMessageContent message =null;	
	private int port;
	
	public UDPSendMessage(String content, InetAddress serverAdress,int port) {
		this.serverAdress = serverAdress;
		this.port = port;
		setContent(content);		
	}
	
	public void setContent(String text){
		message = new UDPMessageContent();
		message.setText(text);
	}
	
	public void sender() throws IOException{
		
		packet = new DatagramPacket(message.getArrayByte(), 
				message.getArrayByte().length, serverAdress, port);
		socket.send(packet);
	}
	
	
}
