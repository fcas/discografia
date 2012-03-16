package rn.ufrn.dimap;

public class HandlerPutCommand extends Handler {
	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
	
		consoleMsg = new ConsoleMessage();
		
		if (request.getCommand().equals(Commands.PUT)){
			consoleMsg.setMessagem("O comando PUT sera tratado.");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
