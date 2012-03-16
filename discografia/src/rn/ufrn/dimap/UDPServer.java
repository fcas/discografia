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
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private SystemConfigurations sysConfig = null;
	private DatagramSocket socket = null;
	private HandlerCommand handlerCommand=null;
	private ConsoleMessage consoleMessage = null;
	
	
	/**
	 * Constroi o componente servidor
	 * @param port a porta de escuta
	 * @param primary e modo: primary e secundary
	 * @throws SocketException 
	 */
	public UDPServer(int port, boolean primary) throws SocketException {
		
		this.port = port;
		this.sysConfig = new SystemConfigurations(); 
		this.socket = new DatagramSocket(port);
		consoleMessage = new ConsoleMessage("Servidor", 
				String.format("iniciado na porta %s",port));
		consoleMessage.print();
		
	}

		
	/**
	 * Fica esperando as requisicoes
	 * @throws SocketException 
	 */
	public void listenIt() throws SocketException{
		
		String contentMessage = null;
				
		while(true){
			
			receiveMessage = new UDPReceiveMessage(port);
			receiveMessage.setSocket(socket);	
			
			try {
				
				receiveMessage.receive();
				contentMessage = receiveMessage.getMessage();
				lineCatch(contentMessage);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
				
		}
		
	}
	
	
	public void lineCatch(String linha){
		
		String del = sysConfig.getDELIMITED_FIELD();
		consoleMessage.setMessagem("Comando mal formado.");
		
		// procura o delimitador das mensagens
		if (linha.contains(del)){
			
			// obtendo os campos comando e argumento
			String cmd = linha.split(del)[0];
			String arg = linha.split(del)[1];
			
			try {
				handlerCommand = new HandlerCommand(cmd, arg);
			} catch (Exception e) {
				consoleMessage.print();
			}
			
			
		}else{
			consoleMessage.print();
		}
		
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

	/**
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * @param request 
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
		
	/**
	 * @return the handlerCommand
	 */
	public HandlerCommand getHandlerCommand() {
		return handlerCommand;
	}


	/**
	 * @param handlerCommand the handlerCommand to set
	 */
	public void setHandlerCommand(HandlerCommand handlerCommand) {
		this.handlerCommand = handlerCommand;
	}


	public static void main(String[] args) {
		
		/*
		if (args.length<1){
			System.err.printf("Usage: %s %s %s\n",UDPServer.class.getName(),
					"port","mode");
			System.exit(1);
		}
		
		int port = Integer.parseInt(args[0]);	// a parta de escuta
		boolean mode = Boolean.parseBoolean(args[1]);	// o modo do componente
*/		
		try {
			
			UDPServer servidor = new UDPServer(1025, true);
			servidor.listenIt();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}