package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPMessageThreadReceiver extends UDPMessage implements Runnable {

	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	private int port;
	
	
	/**
	 * Constroi um objeto runnable para recebimento das menssagens
	 * dos componentes
	 * 
	 * @param port a porta que o componente escutarar
	 * @throws SocketException repassando a Exception 
	 * para o componente
	 */
	public UDPMessageThreadReceiver(int port) throws SocketException {
		this.port=port;
		this.socket = new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		
		byte[] buffer = new byte[1024];
		

		while(true){
			
			try {
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				String message = new String(packet.getData());
				super.setMessage(message);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}

	
}
