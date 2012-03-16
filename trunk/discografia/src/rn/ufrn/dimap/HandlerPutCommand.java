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
			String artista = request.getArgument();
			String info = request.getInfo();
			
			// adicionado a informacao 
			mapArtist.add(String.format("%s", artista.split(del)[0]),info);
				
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