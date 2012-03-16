package rn.ufrn.dimap;

/**
 * O Handler principal, a chamada "porta de entrada" para a nossa
 * corrente" de fluxo continuo
 */

public abstract class Handler {
	
	protected Handler successor;
	
	public void setSucessor(final Handler successor){
		this.successor = successor;
	}
	
	public abstract void handleRequest(final Request request);
	
	
}
