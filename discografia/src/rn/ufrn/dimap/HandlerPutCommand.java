package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */
public class HandlerPutCommand extends Handler {

	private MapArtist mapArtist = null;
	private SystemConfigurations sysConfig = null;
	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		
		mapArtist = new MapArtist();
		sysConfig = new SystemConfigurations();
		consoleMsg = new ConsoleMessage();
		
		if (request.getCommand().equals(Commands.PUT)){
			
			
			String del = sysConfig.getDELIMITED_FIELD();
			String argument = request.getArgument();
						
			// adicionado as informacoes 
			mapArtist.add(argument.split(del)[0],argument.split(del)[1]);
			consoleMsg.setMessagem("O comando Put sera tratado.");
			consoleMsg.print();
				
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

	/**
	 * Retorna a lista de artista 
	 * @return the mapArtist
	 */
	public MapArtist getMapArtist() {
		return mapArtist;
	}

	
	
}