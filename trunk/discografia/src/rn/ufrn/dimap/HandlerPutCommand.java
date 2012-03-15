package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */
public class HandlerPutCommand extends Handler {

	@Override
	public void handleRequest(Commands request) {
		
		// se for o comando put proceder a resposta
		if (request.equals(Commands.PUT)){
			//
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
