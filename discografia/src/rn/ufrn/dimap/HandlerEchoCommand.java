package rn.ufrn.dimap;

/**
 * Trantando o comando Echo
 */

public class HandlerEchoCommand extends Handler {

	private ConsoleMessage consoleMsg = null;
	
	
	@Override
	public void handleRequest(Request request) {
		
		consoleMsg = new ConsoleMessage();
		
		/* Se for o comando echo proceder a resposta */
		if (request.getCommand().equals(Commands.ECHO)){
			consoleMsg.setMessagem("O comando ECHO sera tratado.");
			consoleMsg.print();
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
		
	}
	
	/**
	 * @return the consoleMsg
	 */
	public ConsoleMessage getConsoleMsg() {
		return consoleMsg;
	}

	/**
	 * @param consoleMsg the consoleMsg to set
	 */
	public void setConsoleMsg(ConsoleMessage consoleMsg) {
		this.consoleMsg = consoleMsg;
	}

	
}