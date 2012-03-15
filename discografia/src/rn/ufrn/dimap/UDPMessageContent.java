package rn.ufrn.dimap;


/**
 * Classe usada para usar criar um conteudo
 * de mensagem UDP 
 */
public final class UDPMessageContent{
	 
	private byte[] arrayByte;
	private String text;
	
	
	public byte[] getArrayByte() {
		//return text.getBytes().clone();
		return text.getBytes();
	}

	public synchronized void setArrayByte(final byte[] buffer) {
		this.arrayByte = buffer;
	}

	public synchronized String getText() {
		String text = new String(arrayByte);  
		return text;
	}

	public synchronized void setText(final String text) {
		this.text = text;
	}
	

}