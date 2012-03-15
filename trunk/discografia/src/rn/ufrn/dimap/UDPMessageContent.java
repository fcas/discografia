package rn.ufrn.dimap;


/**
 * Classe usada para usar criar um conteudo
 * de mensagem usando UDP 
 */
public final class UDPMessageContent{
	 
	private byte[] arrayByte;
	private String text;
	
	public byte[] getArrayByte() {
		return text.getBytes().clone();
	}

	public void setArrayByte(byte[] buffer) {
		this.arrayByte = buffer;
	}

	public String getText() {
		String text = new String(arrayByte);  
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}