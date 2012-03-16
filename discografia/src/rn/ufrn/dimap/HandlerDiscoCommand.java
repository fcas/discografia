package rn.ufrn.dimap;

/**
 * Trantando o comando Disco
 */
public class HandlerDiscoCommand extends Handler {

	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		// se for o comando get proceder a resposta
		if (request.getCommand().equals(Commands.DISCO)){
			consoleMsg.setMessagem("O comando DISCO sera tratado.");
			consoleMsg.print();
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
