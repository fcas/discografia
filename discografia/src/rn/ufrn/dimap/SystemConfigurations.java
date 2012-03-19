package rn.ufrn.dimap;

/**
 * Classe usada para obter as configuracoes
 * do sistemas dos componentes da aplicao
 * sera usado na classe Connection
 */
public final class SystemConfigurations {
	private final int TIME_OUT = 2000;
	private final int MAX_LENGTH_MESSAGE = 1024;
	private final String DELIMITED_FIELD = ":";
	private final String DEFAULT_MESSAGE="ECHO";
	private final int DEFAULT_KEY=3;
	private final int NUM_CONNECTION_TRY = 15;
	private final String CONFIG_FILE = "hosts.txt";
	

	/**
	 * @return the dEFAULT_KEY
	 */
	public int getDEFAULT_KEY() {
		return DEFAULT_KEY;
	}

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
	 * @return the dEFAULT_MESSAGE
	 */
	public String getDEFAULT_MESSAGE() {
		return DEFAULT_MESSAGE;
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
	 * @return the nUMBER_DEFAULT_TRY
	 */
	public int getNUMBER_DEFAULT_TRY() {
		return NUM_CONNECTION_TRY;
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
	
	public String getCONFIG_FILE() {
		return CONFIG_FILE;
	}
	
	public String getConfigPath(){
		return workDiretory+fileSeparator+CONFIG_FILE;
	}
	
	
}