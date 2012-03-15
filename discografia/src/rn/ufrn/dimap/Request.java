package rn.ufrn.dimap;



/**
 * Representa uma requisicao que 
 * sera tratada pelo handle 
 */
public class Request {
	
	private Commands command;
	
	
	/**
	 * Controi o objeto requiscao
	 * @param command enum de comandos da aplicao
	 */
	public Request(Commands command) {
		this.command=command;
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

	
	
}
