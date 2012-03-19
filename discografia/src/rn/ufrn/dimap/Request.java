package rn.ufrn.dimap;



/**
 * Representa uma requisicao que 
 * sera tratada pelo handle 
 */
public final class Request {
	
	private Commands command;
	private String argument=null;
	private String host = null;
	private int port;
	private String type;
	
	/**
	 * Controi o objeto requiscao
	 * @param command enum de comandos da aplicacao
	 */
	public Request(Commands command,String argument,String type, String host,int port) {
		this.command=command;
		this.argument=argument;
		this.host = host;
		this.port = port;
		this.type = type;
	}
	
	/**
	 * @return the command
	 */
	public Commands getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(Commands command) {
		this.command = command;
	}

	/**
	 * @return the argument
	 */
	public String getArgument() {
		return argument;
	}

	/**
	 * @param argument the argument to set
	 */
	public void setArgument(String argument) {
		this.argument = argument;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	
}