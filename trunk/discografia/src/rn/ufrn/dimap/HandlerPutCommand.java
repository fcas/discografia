package rn.ufrn.dimap;

/**
 * Trantando o comando get
 */
public class HandlerPutCommand extends Handler {

	private MapArtist mapArtist = null;
	private SystemConfigurations sysConfig = null;
	
	@Override
	public void handleRequest(Request request) {
		
		this.mapArtist = new MapArtist();
		this.sysConfig = new SystemConfigurations();
		
		if (request.getCommand().equals(Commands.PUT)){
			
			String del = sysConfig.getDELIMITED_FIELD();
			String argument = request.getArgument();
						
			// adicionado as informacoes 
			mapArtist.add(argument.split(del)[0],argument.split(del)[1]);
			
				
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