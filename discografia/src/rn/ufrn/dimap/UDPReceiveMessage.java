package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveMessage {
	
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private String menssage = null;
	private SystemConfigurations sysConfig = null;
	private int port;
	
	/**
	 * Constroi o objeto de para receber uma mensagem UDP
	 * @param port a porta de recebimento do pacote
	 * @throws SocketException repassando o erro para componente 
	 */
	public UDPReceiveMessage(int port) throws SocketException {
		
		this.sysConfig = new SystemConfigurations(); 
		this.port = port;
		this.socket = new DatagramSocket(port);
		
	}
	
	
	/**
	 * recebe a mensagem UDP
	 * @throws IOException
	 */
	public void receive() throws Exception{
		
		byte[] arrayByte = new byte[sysConfig.getMAX_LENGTH_MESSAGE()];
		packet = new DatagramPacket(arrayByte,arrayByte.length);
		socket.receive(packet);
		
		String data;
		data = new String(packet.getData());
		
		setMessage(data);
		closeSocket();	
		
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
	
	/**
	 * Fecha o sokete utilizado
	 */
	private void closeSocket(){
		if (socket !=null)
			socket.close();
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
