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
	private boolean primary = true;
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private SystemConfigurations sysConfig = null;
	
	/**
	 * Constroi o componente servidor
	 * @param port a porta de escuta
	 * @param primary e modo: primary e secundary
	 */
	public UDPServer(int port, boolean primary) {
		
		this.port = port;
		this.primary = primary;
		this.sysConfig = new SystemConfigurations();
		
	}

	/**
	 * Fica esperando as requisicoes
	 * @throws SocketException 
	 */
	public void listenIt() throws SocketException{
		
		// abrindo a porta do servidor
		DatagramSocket socket = new DatagramSocket(port);
		String contentMessage = null;
		
		System.out.println("Servidor escutando: ");
		
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
		
		// procura o delimitador das mensagens
		if (linha.contains(sysConfig.getDELIMITED_FIELD())){
			
			// obtendo os campos comando e argumento
			String cmd = linha.split(sysConfig.getDELIMITED_FIELD())[0];
			String arg = linha.split(sysConfig.getDELIMITED_FIELD())[1];
			handlerCommand(cmd, arg);
			
		}
		
	}
	
	public void handlerCommand(String cmd, String arg){
		
		Commands enumCommand;
		
		// a ordem da cadei he importante
		Handler handlerGet = new HandlerGetCommand();
		Handler handlerWhere = new HandlerWhereCommand();
		Handler handlerPut = new HandlerPutCommand();
		Handler handlerEcho = new HandlerEchoCommand();
		
		handlerGet.setSucessor(handlerWhere);
		handlerWhere.setSucessor(handlerPut);
		handlerPut.setSucessor(handlerEcho);
		//		
		
		try {
		
			enumCommand = Commands.valueOf(cmd);
			request = new Request(enumCommand, arg);
			handlerGet.handleRequest(request);
			
			
		} catch (Exception e) {
			System.out.printf("Comando nao implementado: %s",cmd);
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

	/**
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
	public void replicatation(){
		
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
