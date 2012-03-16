package rn.ufrn.dimap;

/**
 * Trantando o comando Echo
 */

public class HandlerEchoCommand extends Handler {

	@Override
	public void handleRequest(Request request) {
		
		/* Se for o comando echo proceder a resposta */
		if (request.getCommand().equals(Commands.ECHO)){
			System.out.println("O servidor recebeu echo");
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
		
	}

}