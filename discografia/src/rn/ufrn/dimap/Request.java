package rn.ufrn.dimap;



/**
 * Representa uma requisicao que 
 * sera tratada pelo handle 
 */
public class Request {
	
	private Commands command;
	private String argument;
	
	/**
	 * Controi o objeto requiscao
	 * @param command enum de comandos da aplicao
	 */
	public Request(Commands command,String argument) {
		this.command=command;
		this.argument=argument;
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

	
	
}
