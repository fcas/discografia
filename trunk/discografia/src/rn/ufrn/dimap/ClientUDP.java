package rn.ufrn.dimap;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientUDP extends UDPMessage {
	
	private String agent=null;
	private UDPMessageThreadReceiver receiver = null;
	private UDPMessageThreadSender sender = null;
	private Connection conection = null;
	private boolean slaver=false;
	
	/**
	 * @return the agent
	 */
	public String getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}

	public ClientUDP(String agent) {
		this.agent = agent;
	}
	
	public void doIt(){
		
		Scanner in = new Scanner(System.in);
		
		Thread th1;
		Thread th2;
	
		while(true){
			
			String linha = in.nextLine();
			
			if(linha.equals("QUIT")){
				break;
			}
			
			if (linha.contains("GET")){
				
				
				try {
					sender = new UDPMessageThreadSender("the cure", InetAddress.getByName("localhost"), 1234);
				 
				// enviou o dado
				th1 = new Thread(sender);
				th1.start();
				
				receiver = new UDPMessageThreadReceiver(1243);
				
				th2 = new Thread(receiver);
				th2.start();
				
				String resp = receiver.getMessage();
				
				// tratador das mensagens
				
				
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	
}
