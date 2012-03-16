package rn.ufrn.dimap;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe usada para guardar a lista de artista
 * envidadas pelo data Provider
 */
public final class MapArtist {
	
	private Map<String,String>mapArtist = null;
	
	public MapArtist() {
		this.mapArtist = new HashMap<String, String>();
	}
	
	
	/**
	 * Adiciona as informacoes no map de artistas
	 * @param artist o nome do artista
	 * @param provider o ip:port data provider
	 */
	public void add(final String artist,final String provider){
		mapArtist.put(artist,provider);
	}


	/**
	 * Encontrar um artista na lista
	 * @param artist o nome do artista
	 * @return as informacoes do provider
	 */
	public String find(String artist){
		
		String provider = null; 
		
		if (mapArtist.containsKey(artist)){
			provider = mapArtist.get(artist);
		}
		
		return provider;
		
	}
	
	/**
	 * Obtem a lista de artistas
	 * @return apArtist o mapa de artistas
	 */
	public Map<String, String> getMapArtist() {
		return mapArtist;
	}
	
}