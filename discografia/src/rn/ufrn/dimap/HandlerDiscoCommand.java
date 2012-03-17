package rn.ufrn.dimap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Trantando o comando Disco
 */
public class HandlerDiscoCommand extends Handler {
	
	private UDPSendMessage sendMessage = null;
	private ConsoleMessage consoleMsg = null;
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		// se for o comando get proceder a resposta
		if (request.getCommand().equals(Commands.DISCO)){
			
			String data = request.getArgument().split(":")[0];
			String ip = request.getArgument().split(":")[1];
			int port = Integer.parseInt(request.getArgument().split(":")[2]);
			
			try {
				sendMessage = new UDPSendMessage(data, InetAddress.getByName(ip),port);
				sendMessage.sender();
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
		}else{
			
			if (successor != null){
				successor.handleRequest(request);
			}
			
		}
	}

}
