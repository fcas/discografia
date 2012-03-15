package rn.ufrn.dimap;


/**
 * Classe usada para usar criar um conteudo
 * de mensagem usando UDP 
 */
public final class UDPMessageContent{
	 
	private byte[] buffer;
	private String content;
	
	/**
	 * Converte um array de byte em string
	 * @return um array de byte
	 */
	public String arrayByteToString()
	{
		content = new String(buffer);
		return content;
	}

	/**
	 * Converte um string em um array de byte
	 * @return um array de byte
	 */
	public byte[] stringToArrayByte()
	{
		return content.getBytes();
	}
	
	/**
	 * Get e Set 
	 */
	
	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}