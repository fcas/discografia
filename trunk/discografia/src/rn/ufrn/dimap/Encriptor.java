package rn.ufrn.dimap;


/**
 * Uma encriptador de mensages com a cifra de Júlio César. 
 * Para descriptografar, use a chave negativo da chave de
 * criptografia.
 *
 */
public class Encriptor {

	private int key;
	private byte[] arrayByteOriginal;
	private byte[] arrayByteEncripted;
	
	/**
	 * Constrói um emcriptador 
	 * @param key a chave de criptografia
	 * @param text o texto a ser criptografado
	 */	
	public Encriptor(int key,String text) {
		super();
		this.key=key;
		this.arrayByteOriginal = text.getBytes();
		
	}

	
	/**
	 * Criptografa o texto
	 * @return result o texto criptografado
	 */
	public String getEncriptedString(){
		int len = arrayByteOriginal.length;
		arrayByteEncripted = new byte[len];
		String result;
		
		for (int i = 0; i < len; i++) {
			arrayByteEncripted[i] = encrypt(arrayByteOriginal[i]);
		}
		
		result = new String(arrayByteEncripted);
		
		return result;
		
	}
	
	/**
	 * Descriptografa o texto
	 * @return result o texto descriptografado
	 */
	public String getDecryptedString(){
		int len = arrayByteEncripted.length;
		byte[] arrayResult = new byte[len];
		String result;
		
		for (int i = 0; i < len; i++) {
			arrayResult[i] = decrypt(arrayByteEncripted[i]);
		}
		
		result = new String(arrayResult);
		
		return result;
		
	}
	
	
	/**
	 * Criptografa um byte 
	 * @param letter o byte a ser criptografado
	 * @return o byte criptografado
	 */
	public byte encrypt(byte letter){
		return (byte)(letter + this.key);
	}
	
	/**
	 * Decrypt um byte 
	 * @param letter o byte a ser descriptografado
	 * @return o byte descriptografado
	 */
	public byte decrypt(byte letter){
		return (byte)(letter - this.key);
	}
}