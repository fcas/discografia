package rn.ufrn.dimap;

/**
 * Classe base para criacao das Classes de envio e recebimento
 * de pacotes UDP
 */

public class UDPMessage{
	 
	private byte[] buffer;
	private String message;
		
	/**
	 * Obtem o texto da mensagem 
	 * @return o texto da mensagem
	 */
	
	public String getMessage()
	{
		message = new String(buffer);
		return message;
	}

	
	/**
	 * Atribui um texto a mensagem
	 * @param sender
	 */
	public void setMessage(String sender) 
	{
		this.message=sender;
	}
			
	/**
	 * Obtem o texto em array de byte
	 * @return o array de byte 
	 */
	public byte[] getBuffer() 
	{
		return buffer;
	}
	
	/**
	 * Atribui array de byte
	 * @param buffer array de byte
	 */
	public void setBuffer(byte[] buffer)
	{
		this.buffer = buffer;
	}
	
}