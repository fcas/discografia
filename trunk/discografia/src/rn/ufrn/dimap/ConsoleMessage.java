package rn.ufrn.dimap;

/**
 * Classe usada para customizar
 * as mensagens dos componente 
 * e mensagens de erro
 */

public final class ConsoleMessage {
	private String agentName;
	private String message;
		
	/**
	 * Constroi o objeto para
	 * @param agent o componente da aplicacao que esta usando o objeto
	 * @param messagem a mensagem que o componente quer criar
	 */
	
	public ConsoleMessage(String agent, String messagem) {
		super();
		setAgent(agent);
		setMessagem(messagem);
	}

	/**
	 * Obtem o componte que esta usando a classe
	 * @return o nome do componente
	 */
	
	public String getAgent() {
		return agentName;
	}

	/**
	 * Configura o nome do componente
	 * @param agent o nome do componente
	 */

	private void setAgent(String agent) {
		this.agentName = agent;
	}

	/**
	 * Obtem a mensagem 
	 * @return a mensagem
	 */
	
	public String getMessagem() {
		return message;
	}

	/**
	 * Configura a mensagem do componente
	 * @param messagem
	 */
	
	private void setMessagem(String messagem) {
		this.message = messagem;
	}
		
	/**
	 * Cria uma saida padrao
	 */
	
	public void print(){
		System.out.printf("%s:%s.\n",this.agentName,this.message);
	}
	
	
}