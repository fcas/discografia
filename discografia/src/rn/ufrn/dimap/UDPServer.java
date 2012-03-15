package rn.ufrn.dimap;

/**
 * Definicao do componente servidor
 * que recebe as requisicoes do outros componentes
 */
public final class UDPServer {
		
	private int port;
	private boolean primary;
	
	
	public UDPServer(int port, boolean primary) {
		
		this.port = port;
		this.primary = primary;
		
	}

	public static void main(String[] args) {
		
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
