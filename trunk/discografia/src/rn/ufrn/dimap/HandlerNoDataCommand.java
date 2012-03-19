package rn.ufrn.dimap;

public class HandlerNoDataCommand extends Handler {

	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		 

		if (request.getCommand().equals(Commands.NODATA)){
			consoleMsg.setMessagem("Disco nao disponível no acervo");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
		
	}

}