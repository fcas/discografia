package rn.ufrn.dimap;

/**
 * Trantando o comando WHERE 
 * 
 */
public class HandlerWhereCommand extends Handler {
	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		
		/* Se for o comando put proceder a resposta */
		if (request.getCommand().equals(Commands.WHERE)){
			consoleMsg.setMessagem("O comando WHERE sera tratado.");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
