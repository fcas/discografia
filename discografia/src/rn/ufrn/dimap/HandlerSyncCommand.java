package rn.ufrn.dimap;

public final class HandlerSyncCommand extends Handler {
	
	private ListServerSecundary listServers = null;
	private ConsoleMessage consoleMsg = null;
		
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		if (request.getCommand().equals(Commands.SYNC)){
			String server = request.getArgument();
			listServers.add(server);
			consoleMsg.setMessagem("O comando SYNC sera tratado.");
			consoleMsg.print();
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}	
		}
	}

	/**
	 * Obtem a lista de servidores secundarios
	 * @return the listServers
	 */
	public ListServerSecundary getListServers() {
		return listServers;
	}
	
}