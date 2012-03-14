package rn.ufrn.dimap;


/**
 * Classe usada para customizar
 * as menssagens dos componente 
 * e messagens de erro
 *
 */
public class ConsoleMessage {
	private String agent;
	private String message;
	
	
	/**
	 * Constroi o objeto para
	 * @param agent o componente da aplicao que esta usando o objeto
	 * @param messagem a mensagem que o componte que criar
	 */
	public ConsoleMessage(String agent, String messagem) {
		super();
		setAgent(agent);
		setMessagem(messagem);
	}

	/**
	 * Obetem o componte que esta usando a classe
	 * @return o nome do componente
	 */
	public String getAgent() {
		return agent;
	}

	
	/**
	 * Configura o nome do componente
	 * @param agent o nome do componente
	 */
	private void setAgent(String agent) {
		this.agent = agent;
	}

	
	/**
	 * Obtem a messagem 
	 * @return a messagem
	 */
	public String getMessagem() {
		return message;
	}

	/**
	 * Configura o mensagem do componente
	 * @param messagem
	 */
	private void setMessagem(String messagem) {
		this.message = messagem;
	}
	
	
	/**
	 * Cria uma saida padrao customizada
	 */
	public void defaultOut(){
		System.out.printf("%s:%s.\n",this.agent,this.message);
	}
	
	/**
	 * Cria uma saida de erro customizada
	 */
	public void outErro(){
		System.err.printf("%s:%s.\n",this.agent,this.message);
	}
	
}