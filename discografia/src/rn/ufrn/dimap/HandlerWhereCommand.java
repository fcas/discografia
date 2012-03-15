package rn.ufrn.dimap;

/**
 * Trantando o comando WHERE 
 * 
 */
public class HandlerWhereCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		// se for o comando put proceder a resposta
		if (request.getCommand().equals(Commands.WHERE)){
			//
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
