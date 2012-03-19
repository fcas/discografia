package rn.ufrn.dimap;

import java.io.IOException;
import java.net.SocketException;


/**
 * Definicao do componente servidor
 * que recebe as requisicoes do outros componentes
 */
public final class UDPServer {
	
	private int port;
	private Request request = null;
	//private UDPReceiveMessage recMenssage = null;
	//private UDPSendMessage sendMessage = null;
	private SystemConfigurations sys = null;
	private Connection connection = null;
	private HandlerCommand handlerCommand = null;
	private boolean primary;
	
	
	public UDPServer(final int port,final boolean primary) throws SocketException {
		
		// abrindo a porta
		this.connection = new Connection(port);
		this.sys = new SystemConfigurations(); 
		this.primary = primary;
		this.port = port;
		
	}

		
	/**
	 * Fica esperando as requisicoes
	 * @throws SocketException 
	 */
	public void listenIt() throws SocketException{
		
		String message = null;
				
		System.out.println(String.format("Servidor iniciado em %s",port));
		
		while(true){
			
			UDPReceiveMessage recMenssage = new UDPReceiveMessage();
			recMenssage.setSocket(connection.getSocket());
			
			try {
				
				recMenssage.receive();
		
				// obtendo os dados do remetente
				String origemHost = recMenssage.getPacket().getAddress().getHostName();
				int origemPort = recMenssage.getPacket().getPort();
				message = recMenssage.getTex();
				
				if ( message != null){
					
					lineCatch(message,origemHost,origemPort);
				}
				
				
			} catch (IOException e) {
				System.err.println(String.format("%s", e.getCause().getMessage()));
			}
					
		}
			
	}
	
	
	public void lineCatch(String line,String host,int port){
		
		String del = sys.getDELIMITED_FIELD();
	
		// procura o delimitador das mensagens
		if (line.contains(del)){
			
			// quebrando a linha
			String cmd = line.split(del)[0];
			String arg = line.split(del)[1];
			String type = line.split(del)[2];
			
			try {
				// chama o tratador de comandos
				handlerCommand = new HandlerCommand(cmd, arg,type, host, port);
				
			} catch (Exception e) {
				
				System.err.println(String.format("%s", e.getCause().getMessage()));
				
			}
			
			
		}else{
			System.err.println(String.format("Comando mal formado %s",line));
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

	
	public static void main(String[] args) {
		
		try {
			
			UDPServer servidor = new UDPServer(1025, true);
			servidor.listenIt();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		
	}
	
}