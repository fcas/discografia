package rn.ufrn.dimap;

import java.net.DatagramSocket;
import java.util.Scanner;
import CHandler; 

public class UDPClient extends UDPMessage {

	private DatagramSocket soket =null;
	private Connection cnn = null;
	private UDPMessageThreadSend s=null;
	private UDPMessageThreadReceive r=null;
	private Disco disco;
	
	Scanner in = new Scanner(System.in);

	while (true) {
		cnn = new Connection("host.txt","");
		String msg = in.nextLine();
		
		if (msg == "QUIT"){
			break;
		} else {
			
		}
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
				
				System.out.println("infome ano");
						
				
				s.setMessage(linha);
				r.getMessage();
				
				
				th1 = new Thread(s);
				th2 = new Thread(r);
			}
			
			
		}
		
		
	}
	
	
}
