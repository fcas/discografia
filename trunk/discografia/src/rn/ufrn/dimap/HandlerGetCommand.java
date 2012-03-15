package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */

public class HandlerGetCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		/* Se for o comando get proceder a resposta */
		if (request.getCommand().equals(Commands.GET)){
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
