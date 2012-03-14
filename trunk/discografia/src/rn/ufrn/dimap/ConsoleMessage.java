package rn.ufrn.dimap;


public class ConsoleMessage {
	private String agent;
	private String message;
	
	public ConsoleMessage(String agent, String messagem) {
		super();
		setAgent(agent);
		setMessagem(messagem);
	}

	public String getAgent() {
		return agent;
	}

	private void setAgent(String agent) {
		this.agent = agent;
	}

	public String getMessagem() {
		return message;
	}

	private void setMessagem(String messagem) {
		this.message = messagem;
	}
	
	public void defaultOut(){
		System.out.printf("%s:%s.\n",this.agent,this.message);
	}
	
	public void outErro(){
		System.err.printf("%s:%s.\n",this.agent,this.message);
	}
	
}