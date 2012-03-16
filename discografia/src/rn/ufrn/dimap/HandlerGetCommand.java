package rn.ufrn.dimap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Trantando o comando get
 */

public class HandlerGetCommand extends Handler {

	//private DatagramSocket s = null;
	//private UDPSendMessage sendMessage = null;
	private ConsoleMessage consoleMsg = null;
	private Connection connection = null;
	private UDPSendMessage sendMessage = null;
	
	@Override
	public void handleRequest(Request request) {
		consoleMsg = new ConsoleMessage();
		consoleMsg.setAgent("DataProvider");
		
		if (request.getCommand().equals(Commands.GET)){
			consoleMsg.setMessagem("recebeu um pedido");
			
			try {
				
				String data = request.getArgument().split(":")[0];
				String ip = request.getArgument().split(":")[1];
				int port = Integer.parseInt(request.getArgument().split(":")[2]);
				
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
