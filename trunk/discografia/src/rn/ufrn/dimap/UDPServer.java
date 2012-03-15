package rn.ufrn.dimap;


/**
 * Definicao do componente servidor
 * que recebe as requisicoes do outros componentes
 */
public final class UDPServer {
		
	private int port;
	private boolean primary;
	private UDPReceiveMessage receiveMessage=null;
	private UDPSendMessage sendMessage=null;
	private Request request = null;
	private HandlerGetCommand getCommand = null;
	
	
	/**
	 * Constroi o componente servidor
	 * @param port a porta de escuta
	 * @param primary e modo: primary e secundary
	 */
	public UDPServer(int port, boolean primary) {
		
		this.port = port;
		this.primary = primary;
		
	}

	public static void main(String[] args) {
		
		if (args.length<1){
			System.err.printf("Usage: %s %s %s\n",UDPServer.class.getClass(),"port","mode");
			System.exit(1);
		}
		
		int port = Integer.parseInt(args[0]);	// a parta de escuta
		boolean mode = Boolean.parseBoolean(args[1]);	// o modo do componente
		
		new UDPServer(port, mode).doIt();
		
	}
	
	
	/**
	 * Fica esperando as requisicoes
	 */
	public void doIt(){
		
		while(true){
					
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
