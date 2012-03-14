package rn.ufrn.dimap;

/**
 * Uma estrutara para armazenar dados de uma 
 * discografia
 */
public class Disco {
	private int ano;
	private String album;
	private String tipo;
	
	
	/**
	 * Constroi uma registro de discografia
	 * @param ano do trabalho
	 * @param album nome do trabalho
	 * @param tipo do trabalho
	 */
	public Disco(int ano, String album, String tipo) {
		super();
		this.ano = ano;
		this.album = album;
		this.tipo = tipo;
	}

	
	/**
	 * Obtem o ano to album
	 * @return ano
	 */
	public int getAno() {
		return ano;
	}

	
	/**
	 * Configura o ano do album
	 * @param ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	
	/**
	 * Obtem o nome do album
	 * @return album
	 */
	public String getAlbum() {
		return album;
	}

	
	/**
	 * Configura o nome do album
	 * @param album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	
	/**
	 * Obtem o tipo de trabalho
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Configura o tipo de tabalho
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}