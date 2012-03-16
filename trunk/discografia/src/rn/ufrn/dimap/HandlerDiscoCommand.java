package rn.ufrn.dimap;

/**
 * Trantando o comando Disco
 */
public class HandlerDiscoCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		// se for o comando get proceder a resposta
		if (request.getCommand().equals(Commands.DISCO)){
			//
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
