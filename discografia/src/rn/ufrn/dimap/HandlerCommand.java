package rn.ufrn.dimap;

public class HandlerCommand{

	private Handler handlerGet = null;
	private Handler handlerPut = null;
	private Handler handlerDisco = null;
	private Handler handlerWhere = null;
	private Handler handlerEcho = null;
	private Handler handlerSync = null;
	private Request request = null;
	private Commands enumCommand;
	private String command;
	private String argument;
	
	/**
	 * Constroi o objeto tatrador de comandos
	 * @param cmd o comando a tratado
	 * @param arg o argumento do comando
	 * @throws repassa o Exception para o componente
	 */
	public HandlerCommand (String cmd, String arg) throws Exception {

		// criando as instancias do handler
		createInstances();
	
		// verificando se o comando e o esperado
		enumCommand = Commands.valueOf(cmd);
		
		// criando os dados da requisicao
		request = new Request(enumCommand, arg);
		
		chainOfResponsibility(); 				// defina a sucessao
		handlerGet.handleRequest(request); 		// inicia a cadeia
		
	}
	
		
	/**
	 * Obtem o comando solicitado
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
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
	 * Cria a instancias dos handles dos comandos 
	 * 
	 */
	private void createInstances(){
		
		handlerGet = new HandlerGetCommand();
		handlerPut = new HandlerPutCommand();
		handlerDisco = new HandlerDiscoCommand();
		handlerWhere = new HandlerWhereCommand();
		handlerEcho = new HandlerEchoCommand();
		handlerSync = new HandlerSyncCommand();
		
	}
	
	
	public void setArgs(String cmd, String arg){
		this.command=cmd;
		this.argument=arg;
	}
	
	/**
	 * Iniciando a cadeia de responsabilidade
	 */
	private void chainOfResponsibility(){	
		
		handlerGet.setSucessor(handlerPut);
		handlerPut.setSucessor(handlerDisco);
		handlerDisco.setSucessor(handlerWhere);
		handlerWhere.setSucessor(handlerEcho);
		handlerEcho.setSucessor(handlerSync);
		
	}

	/**
	 * @return the handlerSync
	 */
	
	public Handler getHandlerSync() {
		return handlerSync;
	}

	/**
	 * @return the handlerPut
	 */
	public Handler getHandlerPut() {
		return handlerPut;
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
	
}