package rn.ufrn.dimap;

public class ConsoleMessage {
	private String agent;
	private String messagem;
	
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
		return messagem;
	}

	private void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	
	public void printOut(){
		System.out.printf("%s:%s.\n",this.agent,this.messagem);
	}
	
	public void PrintErro(){
		System.err.printf("%s:%s.\n",this.agent,this.messagem);
	}
	
}
