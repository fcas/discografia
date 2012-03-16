package rn.ufrn.dimap;

public final class HandlerSyncCommand extends Handler {
	
	private ListServerSecundary listServers = null;
		
	@Override
	public void handleRequest(Request request) {
		
		if (request.getCommand().equals(Commands.SYNC)){
			String server = request.getArgument();
			listServers.add(server);
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