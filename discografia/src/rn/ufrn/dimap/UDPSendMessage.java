package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 * Classe para enviar mensagens UDP
 */
public final class UDPSendMessage {
	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private InetAddress serverAdress = null;
	private UDPMessageContent udpMessageContent = null;	
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
		
		packet = new DatagramPacket(udpMessageContent.getArrayByte(), 
				udpMessageContent.getArrayByte().length, serverAdress, port);
		socket.send(packet);
		closeSocket();		
	}
	
	/**
	 * Configura o conteudo a mensagem
	 * @param text
	 */
	private void setContent(String text){
		udpMessageContent = new UDPMessageContent();
		udpMessageContent.setText(text);
	}
	
	/**
	 * Fecha o sokete utilizado
	 */
	private void closeSocket(){
		if (socket !=null)
			socket.close();
	}
	
	// teste simple de envio de mensagem
	public static void main(String[] args) {
		try {
			
			System.out.println("cliente enviando ");
			new UDPSendMessage("ECHO:ECHO", InetAddress.getByName("localhost"),1025).sender();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
