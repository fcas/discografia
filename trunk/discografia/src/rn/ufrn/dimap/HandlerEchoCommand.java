package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */
public class HandlerEchoCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		// se for o comando echo proceder a resposta
		if (request.getCommand().equals(Commands.ECHO)){
			System.out.println("echo");
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
		
	}

}
