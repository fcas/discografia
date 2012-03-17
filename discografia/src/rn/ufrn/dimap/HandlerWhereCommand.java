package rn.ufrn.dimap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HandlerWhereCommand extends Handler {
	
	private ConsoleMessage consoleMsg = null;
	UDPSendMessage sendMessage = null;

	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		
		
		if (request.getCommand().equals(Commands.WHERE)){
			
			String data = request.getArgument();
	
			try {
				sendMessage = new UDPSendMessage(data, InetAddress.getByName("localhost"),1025);
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