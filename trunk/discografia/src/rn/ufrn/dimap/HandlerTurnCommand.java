package rn.ufrn.dimap;

public class HandlerTurnCommand extends Handler {
	private ConsoleMessage consoleMsg=null;
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		consoleMsg.setMessagem("Nao ha mais sucessores");
	}
	
}
