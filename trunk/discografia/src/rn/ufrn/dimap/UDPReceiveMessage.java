package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPReceiveMessage {
	
	private UDPMessageContent messageContent = null;
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private SystemConfigurations sys = null;
	private byte[] buffer = null;
	private String text = null;
	
	public UDPReceiveMessage() throws SocketException {
		
		sys = new SystemConfigurations();
		
	}
	
	
	public void receive() throws IOException{
		
		int length = sys.getMAX_LENGTH_MESSAGE();
		// preparando um objeto para receber
		// o conteudo cifrado
		messageContent = new UDPMessageContent(length);
		buffer = new byte[length];
		packet = new DatagramPacket(buffer,buffer.length);
		socket.receive(packet);
		// passando o array de bytes recebido 
		// decrifar
		messageContent.setBytes(packet.getData());
		setText(messageContent.getText());
		
	}
	
	public synchronized String getTex(){
		return text;
	}
	
	public synchronized void setText(final String text){
		this.text = text;
	}
	
	public synchronized DatagramPacket getPacket() {
		return packet;
	}


	/**
	 * @param socket the socket to set
	 */
	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}


	/**
	 * @return the socket
	 */
	public DatagramSocket getSocket() {
		return socket;
	}
	
}