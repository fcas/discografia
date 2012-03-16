package rn.ufrn.dimap;


/**
 * Enumerador usado para tratar os omandos dos protocolo da aplicacao:
 * 
 * echo - usado para teste de conexao
 * data - usado para enviar dados 
 * get  - solicitar dados de discografias
 * put  - enviar dados de artistas
 * sync - solicitar dados de syncrolizacao de dados
 * disc - envia dados de discografias
 *  
 */
public enum Commands {
	ECHO,
	DATA,
	GET,
	PUT,
	WHERE,
	SYNC,
	DISCO
}