package rn.ufrn.dimap;

/**
 * Classe usada para obter as configuracoes
 * do sistemas dos componentes da aplicao
 * sera usado na classe Connection
 */

public final class SystemConfigurations {
	private final int TIME_OUT = 6000;
	private final int MAX_LENGTH_MESSAGE = 1024;
	private final String DELIMITED_FIELD = ":";
	private String os = null;
	private String fileSeparator = null;
	private String workDiretory=null;
		
	/**
	 * Constroi o objeto com informacoes
	 * sobre o ambiente de execucao do componente
	 * @param fileName
	 */
	
	
	public SystemConfigurations() {
		setOs();
		setFileSeparator();
		setWorkDiretory();
		
	}
	
	/**
	 * Obtem o sistema operacional 
	 * do componente
	 * @return os nome do sistema operacional
	 */
	
	public String getOs() {
		return os;
	}
	
	/**
	 * Atribui o sistema operaciona do
	 * componente  
	 */
	
	private void setOs() {
		this.os = System.getProperty("os.name");
	}

	/**
	 * Obetem o separador do caminho dos arquivos
	 * @return o separador o caminho dos arquivos
	 */
	
	public String getFileSeparator() {
		return fileSeparator;
	}

	/**
	 * Atribui o caracter de separacao do caminho 
	 * dos arquivos
	 */
	
	private void setFileSeparator() {
		this.fileSeparator = System.getProperty("file.separator");
	}
	
	/**
	 * Obtem o atual diretorio de trabalho
	 * @return workDiretory o caminho da aplicao
	 */
	
	public String getWorkDiretory() {
		return workDiretory;
	}

	/**
	 * Configura o atual diretorio de trabalho
	 * do componente
	 */
	
	private void setWorkDiretory() {
		this.workDiretory = System.getProperty("user.dir");
	}
	
	/**
	 * Configura o comprimento maximo das mansagens
	 * @return o comprimento maxima das mensagens
	 */
	public int getMAX_LENGTH_MESSAGE() {
		return MAX_LENGTH_MESSAGE;
	}

	/** 
	 * Obtem o time de espera do socket
	 * @return TIME_OUT o tempo  de espera do socket
	 */
	public int getTIME_OUT() {
		return TIME_OUT;
	}
	
	/**
	 * @return the dELIMITED_FIELD
	 */
	public String getDELIMITED_FIELD() {
		return DELIMITED_FIELD;
	}
	
}