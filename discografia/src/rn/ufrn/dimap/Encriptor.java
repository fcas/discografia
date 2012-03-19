package rn.ufrn.dimap;

/**
 * Uma encriptador de mensages com a cifra de Júlio César. 
 * Para descriptografar, use a chave negativo da chave de
 * criptografia.
 */

public final class Encriptor {

	private int key;
	private byte[] arrayByteOriginal;
	private byte[] arrayByteModificate;
	
	/**
	 * Constroi um encriptador 
	 * @param key a chave de criptografia
	 * @param content o texto a ser criptografado
	 */		
	public Encriptor(int key,byte[] content) {
		
		this.key=key;
		this.arrayByteOriginal = content;
					
	}

	/**
	 * Faz a criptografia do dado
	 * 
	 */
	public void doEncription(){
		
		int length = arrayByteOriginal.length;
		arrayByteModificate = new byte[length];
				
		for (int i = 0; i < length; i++) {
			
			if (arrayByteOriginal[i] !=0 ){
				arrayByteModificate[i] = encrypt(arrayByteOriginal[i]);
			}
			
		}

	}
	
	/**
	 * Criptografa o texto
	 * @return result o texto criptografado
	 */
	public byte[] getEncripted(){
		return arrayByteModificate.clone();
	}
	
		
	/**
	 * Realiza a descriptografa o texto
	 * @return result o texto descriptografado
	 */
	public byte[] doDecrypted(){
		
		int length = arrayByteOriginal.length;
		arrayByteModificate = new byte[length];
			
		for (int i = 0; i < length; i++) {
			
			if(arrayByteOriginal[i] != 0){
				arrayByteModificate[i] = decrypt(arrayByteOriginal[i]);
			}
			
		}
		
		return arrayByteModificate.clone();
		
	}
	
	
	/**
	 * Retorna o texto descriptografado
	 * @return o array de bytes
	 */
	public byte[] getDecrypted(){
		return arrayByteModificate.clone();
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