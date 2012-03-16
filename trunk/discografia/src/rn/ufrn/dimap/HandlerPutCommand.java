package rn.ufrn.dimap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HandlerPutCommand extends Handler {
	private ConsoleMessage consoleMsg = null;
	private Connection connection = null;
	private UDPSendMessage sendMessage = null;
		
	@Override
	public void handleRequest(Request request) {
	
		consoleMsg = new ConsoleMessage();
		consoleMsg.setAgent("DataProvider");
		
		if (request.getCommand().equals(Commands.PUT)){
	
			String messagem = new String(request.getArgument());
			
			
			try {
				sendMessage = new UDPSendMessage(messagem, InetAddress.getByName("localhost"),1025);
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
