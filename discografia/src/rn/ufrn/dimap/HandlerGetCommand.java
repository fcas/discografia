package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */

public class HandlerGetCommand extends Handler {

	//private DatagramSocket s = null;
	//private UDPSendMessage sendMessage = null;
	private ConsoleMessage consoleMsg = null;
	
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		
		if (request.getCommand().equals(Commands.GET)){
			consoleMsg.setMessagem("O comando GET sera tratado.");
			consoleMsg.print();
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
