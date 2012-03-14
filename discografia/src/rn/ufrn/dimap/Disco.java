package rn.ufrn.dimap;

public class Disco {
	private int ano;
	private String album;
	private String tipo;

	public UDPData (String agent) {
		super(agent);
		cnnD = new Connection("hostx.txt","");
	
		
	}
	
	
	public Disco(int ano, String album, String tipo) {
		super();
		this.ano = ano;
		this.album = album;
		this.tipo = tipo;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}