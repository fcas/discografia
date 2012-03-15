package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * Definicao do componente servidor
 * que recebe as requisicoes do outros componentes
 */
public final class UDPServer {
		
	private int port;
	private boolean primary;
	private Request request = null;
	private HandlerGetCommand getCommand = null;
	private UDPReceiveMessage receiveMessage = null;
	//private UDPSendMessage sendMessage = null;
	
	
	/**
	 * Constroi o componente servidor
	 * @param port a porta de escuta
	 * @param primary e modo: primary e secundary
	 */
	public UDPServer(int port, boolean primary) {
		
		this.port = port;
		this.primary = primary;
		
	}

	/**
	 * Fica esperando as requisicoes
	 * @throws SocketException 
	 */
	public void doIt() throws SocketException{
		
		// abrindo a porta do servidor
		DatagramSocket socket = new DatagramSocket(port);
		String data = null;
		
		while(true){
			
			receiveMessage = new UDPReceiveMessage();
			receiveMessage.setSocket(socket);	
			
			try {
				receiveMessage.receive();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		if (args.length<1){
			System.err.printf("Usage: %s %s %s\n",UDPServer.class.getClass(),"port","mode");
			System.exit(1);
		}
		
		int port = Integer.parseInt(args[0]);	// a parta de escuta
		boolean mode = Boolean.parseBoolean(args[1]);	// o modo do componente
		
		try {
			
			new UDPServer(port, mode).doIt();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * @return the primary
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * @param primary the primary to set
	 */
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
	
}
