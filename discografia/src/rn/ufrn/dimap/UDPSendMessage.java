package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public final class UDPSendMessage {
	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private InetAddress serverAdress = null;
	private UDPMessageContent message =null;	
	private int port;
	
	
	/**
	 * Constroi o objeto de para envio da mensagem UDP
	 * @param content o corpa da mensagem
	 * @param serverAdress o endereco de destino
	 * @param port a porta de destino
	 * @throws SocketException repassando o erro para componente 
	 */
	public UDPSendMessage(String content, InetAddress serverAdress,int port) throws SocketException {
		this.socket = new DatagramSocket();
		this.serverAdress = serverAdress;
		this.port = port;
		setContent(content);		
	}
	
	
	/**
	 * Envia a mensagem UDP
	 * @throws IOException
	 */
	public void sender() throws IOException{
		
		packet = new DatagramPacket(message.getArrayByte(), 
				message.getArrayByte().length, serverAdress, port);
		socket.send(packet);
		closeSocket();		
	}
	
	/**
	 * Configura o conteudo a mensagem
	 * @param text
	 */
	private void setContent(String text){
		message = new UDPMessageContent();
		message.setText(text);
	}
	
	private void closeSocket(){
		if (socket !=null)
			socket.close();
	}
	
	
	
}
