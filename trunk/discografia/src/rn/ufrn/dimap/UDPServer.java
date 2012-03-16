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
	private Handler handlerGet = null;
	private Handler handlerWhere = null;
	private Handler handlerPut = null;
	private Handler handlerEcho = null;
	private Handler handlerSync = null;
	private DatagramSocket socket = null;
	
	
	/**
	 * Constroi o componente servidor
	 * @param port a porta de escuta
	 * @param primary e modo: primary e secundary
	 * @throws SocketException 
	 */
	public UDPServer(int port, boolean primary) throws SocketException {
		
		this.port = port;
		this.handlerGet = new HandlerGetCommand();
		this.handlerWhere = new HandlerWhereCommand();
		this.handlerPut = new HandlerPutCommand();
		this.handlerEcho = new HandlerEchoCommand();
		this.handlerSync = new HandlerSyncCommand();
		this.sysConfig = new SystemConfigurations();
		// abrindo a porta 
		this.socket = new DatagramSocket(port);
		
		// Corrente de sucessão
		handlerGet.setSucessor(handlerWhere);
		handlerWhere.setSucessor(handlerPut);
		handlerPut.setSucessor(handlerEcho);
		handlerEcho.setSucessor(handlerSync);
		
		
		if (!primary){
			Request requestSync = new Request(Commands.SYNC,"");
			handlerSync.handleRequest(requestSync);
		}
		
		
	}

		
	/**
	 * Fica esperando as requisicoes
	 * @throws SocketException 
	 */
	public void listenIt() throws SocketException{
		
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
		
		String del = sysConfig.getDELIMITED_FIELD();
		
		// procura o delimitador das mensagens
		if (linha.contains(del)){
			
			// obtendo os campos comando e argumento
			String cmd = linha.split(del)[0];
			String arg = linha.split(del)[1];
			
			handlerCommand(cmd, arg);
			
		}else{
			System.out.printf("comando mal formado: %s",linha);
		}
		
	}
	
	public void handlerCommand(String cmd, String arg){
		
		Commands enumCommand;
						
		try {
		
			enumCommand = Commands.valueOf(cmd);
			request = new Request(enumCommand, arg);
			// chamando o primeiro handler da corrente
			handlerGet.handleRequest(request);
			
			
		} catch (Exception e) {
			System.out.printf("Comando nao implementado: %s",cmd);
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
	 * @return the handlerPut
	 */
	public Handler getHandlerPut() {
		return handlerPut;
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