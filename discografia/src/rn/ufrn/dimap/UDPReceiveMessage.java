package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * Classe para receber mensagens UDP
 *
 */
public class UDPReceiveMessage {
	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private String menssage = null;
	private SystemConfigurations sysConfig = null;
	private int port;
	
	
	/**
	 * Construtor padrao
	 */
	public UDPReceiveMessage() {
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constroi o objeto de para receber uma mensagem UDP
	 * @param port a porta de recebimento do pacote
	 * @throws SocketException repassando o erro para componente 
	 */
	public UDPReceiveMessage(int port) throws SocketException {
		this.sysConfig = new SystemConfigurations(); 
		this.port = port;
	}
	
	
	/** Configura um DatagramSocket
	 * @param socket the socket to set
	 */
	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}
	
	/**
	 * recebe a mensagem UDP
	 * @throws IOException
	 */
	public void receive() throws IOException{
		
		byte[] arrayByte = new byte[sysConfig.getMAX_LENGTH_MESSAGE()];
		packet = new DatagramPacket(arrayByte,arrayByte.length);
		socket.receive(packet);
		
		String data;
		data = new String(packet.getData());
		
		setMessage(data);

	}
	

	/**
	 * Obtem a porta para receber a mensagem
	 * @return port o porta da envio da mensagem
	 */
	public int getPort() {
		return port;
	}


	/**
	 * Configura a porta para recebimento
	 * da mensagem
	 * @param port a porta para recebimento
	 */
	public void setPort(int port) {
		this.port = port;
	}

	public String getMessage(){
		return menssage;
	}
	
	private void setMessage(String text){
		this.menssage=text;
	}
	
	/* teste simple de envio de mensagem
	public static void main(String[] args) {
		try {
			
			UDPReceiveMessage mensagem = new UDPReceiveMessage(1025);
			
			new UDPSendMessage("ola", InetAddress.getByName("localhost"),1025).sender();
			mensagem.receive();
			System.out.println(mensagem.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	*/
}
