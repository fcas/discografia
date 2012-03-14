package rn.ufrn.dimap;

public class UDPMessage{
	 
	private byte[] buffer;
	private String message;
	
	
	/*public UDPMessage(String message)
	{
		this.buffer = message.getBytes();
	}*/
	
	public String getMessage()
	{
		message = new String(buffer);
		return message;
	}

	public void setMessage(String sender) 
	{
		this.message=sender;
	}
			
	public byte[] getBuffer() 
	{
		return buffer;
	}
	
	public void setBuffer(byte[] buffer)
	{
		this.buffer = buffer;
	}
	

}