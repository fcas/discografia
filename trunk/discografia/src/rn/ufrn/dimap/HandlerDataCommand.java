package rn.ufrn.dimap;

/**
 * Trantando o comando Data
 */
public class HandlerDataCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		// se for o comando get proceder a resposta
		if (request.getCommand().equals(Commands.DATA)){
			//
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
