package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */
public class HandlerGetCommand extends Handler {

	@Override
	public void handleRequest(Commands request) {
		
		// se for o comando get proceder a resposta
		if (request.equals(Commands.GET)){
			//
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
