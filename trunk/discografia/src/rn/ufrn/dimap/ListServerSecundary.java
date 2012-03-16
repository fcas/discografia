package rn.ufrn.dimap;

import java.util.HashSet;
import java.util.Set;


/**
 * Classe usada para gerenciar o mapa
 * de servidores secundarios para envio
 * das atualizacoes
 */
public final class ListServerSecundary {

	/* Nao permite dados repetidos */
	private Set<String>listSecundaryServer = null;
	
	public ListServerSecundary() {
		this.listSecundaryServer = new HashSet<String>();
	}
	
	/**
	 * Adiciona as informacoes no map de artistas
	 * @param artist o nome do artista
	 * @param provider o ip:port data provider
	 */
	public void add(final String provider){
		listSecundaryServer.add(provider);
	}


	
	/**
	 * Obtem a lista de artistas
	 * @return apArtist o mapa de artistas
	 */
	public Set<String>listSerers() {
		return listSecundaryServer;
	}
	
}