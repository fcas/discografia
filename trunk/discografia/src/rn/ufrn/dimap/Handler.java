package rn.ufrn.dimap;

public abstract class Handler {
	
	protected Handler sucessor;
	
	public void setSucessor(final Handler sucessor){
		this.sucessor = sucessor;
	}
	
	public abstract void handleRequest(final Commands request);
	
	
}
