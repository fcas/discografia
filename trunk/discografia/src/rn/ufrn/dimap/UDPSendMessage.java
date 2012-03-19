package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class UDPSendMessage {

	private UDPMessageContent messageContent = null;	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private byte[] buffer = null;
	private InetAddress inetAdress = null;
	private int port;

	public UDPSendMessage(final byte[] buffer) {
		
		this.messageContent = new UDPMessageContent(buffer);
		setBuffer(messageContent.getBytes());
		
	}
	
	/**
	 * @param buffer the buffer to set
	 */
	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}
	
	/**
	 * @return the packet
	 */
	public DatagramPacket getPacket() {
		return packet;
	}
	
	/**
	 * @return the socket
	 */
	public DatagramSocket getSocket() {
		return socket;
	}
	

	/**
	 * @param socket the socket to set
	 * @throws UnknownHostException 
	 */
	public void setSocket(final DatagramSocket socket) throws UnknownHostException {
		this.socket = socket;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(final int port) {
		this.port = port;
	}

	/**
	 * @param inetAdress the inetAdress to set
	 * @throws UnknownHostException 
	 */
	public void setInetAdress(final String host) throws UnknownHostException {
		this.inetAdress = InetAddress.getByName(host);
	}
	
	public void send() throws IOException{
		
		socket = new DatagramSocket();
		socket.connect(inetAdress,port);
			
		packet = new DatagramPacket(buffer,buffer.length);
		socket.send(packet);
		
	}
	
}