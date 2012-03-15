package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Objeto runnable para envio das mesnagens dos
 * componentes da aplicacao
 */

public class UDPMessageThreadSender extends UDPMessage implements Runnable {
	
	private InetAddress address;
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private int port;	
	
	/**
	 * Constroi um objeto runnable para envio das menssagens
	 * doscomponentes
	 * 
	 * @param message a mensagem sera enviada
	 * @param address o endereco de destino da mensagem
	 * @param port a porta do destino
	 * @throws SocketException repassando a Exception para
	 * o componente 
	 */
	
	public UDPMessageThreadSender(String message,InetAddress address,int port)
			throws	SocketException {
		
		super.setMessage(message);
		this.port=port;
		setAddress(address);
		this.socket = new DatagramSocket();	
				
	}
	
	@Override
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

	
	/**
	 * Obtem o endereco do endereco de destino
	 * da mensagem
	 */
	
	public InetAddress getAddress() {
		return address;
	}
	
	/**
	 * Configura o endereco de destino
	 * da mensagem
	 */
	
	private void setAddress(InetAddress address) {
		this.address = address;
	}

	
	
}


