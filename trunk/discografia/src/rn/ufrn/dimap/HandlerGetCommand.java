package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * Trantando o comando get
 */

public class HandlerGetCommand extends Handler {

	private DatagramSocket s = null;
	private UDPSendMessage sendMessage = null;
	private Connection connect = null;
	
	@Override
	public void handleRequest(Request request) {
		
		/* Se for o comando get proceder a resposta */
		if (request.getCommand().equals(Commands.GET)){
			
			connect = new Connection("hosts.txt", "Client");
			/*sendMessage = new UDPSendMessage(request.getArgument(), connect.getAddress(), port);
			 * PRECISAMOS DESCOBRIR COMO É QUE O GET VAI SABER A PORTA DO SERVIDOR PELO CONNECTION.*/
			System.out.println("\n* Client: Socket criado na porta: " + s.getLocalPort());
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
