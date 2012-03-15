package rn.ufrn.dimap;

/**
 * Classe usada para obter as configuracoes
 * do sistemas dos componentes da aplicao
 * sera usado na classe Connection
 */

public class SystemConfigurations {
	
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
	
}