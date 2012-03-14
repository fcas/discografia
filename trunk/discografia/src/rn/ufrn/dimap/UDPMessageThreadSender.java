package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 * Objeto runnable para envio das mesagens dos
 * componentes da aplicao
 */
public class UDPMessageThreadSender extends UDPMessage implements Runnable {
	
	private InetAddress address;
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private int port;
			
	
	
	/**
	 * Constroi um objeto runnable para envio das menssagens dos componentes
	 * @param message a mensagem sera enviada
	 * @param address o endereco de destino da mensagem
	 * @param port a porta do destino
	 */
	public UDPMessageThreadSender(String message,InetAddress address,int port) {
		
		super.setMessage(message);
		this.port=port;
		setAddress(address);
		
		try {
			this.socket = new DatagramSocket();	
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
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


