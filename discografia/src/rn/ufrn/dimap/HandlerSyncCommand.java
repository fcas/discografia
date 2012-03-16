package rn.ufrn.dimap;

public class HandlerSyncCommand extends Handler {

	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		
		if (request.getCommand().equals(Commands.SYNC)){
			consoleMsg.setMessagem("O comando SYNC sera tratado.");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}
}