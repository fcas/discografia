package rn.ufrn.dimap;

public class HandlerWhereCommand extends Handler {
	
	private ConsoleMessage consoleMsg = null;

	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		
		if (request.getCommand().equals(Commands.WHERE)){
			consoleMsg.setMessagem("O comando WHERE sera tratado.");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}
}