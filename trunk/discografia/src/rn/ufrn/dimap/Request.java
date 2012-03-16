package rn.ufrn.dimap;



/**
 * Representa uma requisicao que 
 * sera tratada pelo handle 
 */
public final class Request {
	
	private Commands command;
	private String argument;
	private String info = null;	// usado para armazenar as informacoes do requisitante
	
	/**
	 * Controi o objeto requiscao
	 * @param command enum de comandos da aplicacao
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

	/**
	 * Guarda informacoes extra sobre o requisitante
	 * @param info as informacoes sobre o requisitante
	 */
	public void setInfo(String info){
		this.info=info;
	}
	
	/**
	 * Pegas os dados extras do requisitante
	 * @return
	 */
	public String getInfo(){
		return info;
	}
	
}