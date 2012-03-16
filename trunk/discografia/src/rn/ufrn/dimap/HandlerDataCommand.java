package rn.ufrn.dimap;

/**
 * Trantando o comando Data
 */
public class HandlerDataCommand extends Handler {

	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		// se for o comando get proceder a resposta
		if (request.getCommand().equals(Commands.DATA)){
			consoleMsg.setMessagem("O comando DATA sera tratado.");
			consoleMsg.print();
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
