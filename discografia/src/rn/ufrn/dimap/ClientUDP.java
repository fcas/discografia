package rn.ufrn.dimap;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ClientUDP {

	private UDPReceiveMessage receiveMessage = null;
	private UDPSendMessage sendMessage = null;
	private SystemConfigurations sys = null;
	private HandlerCommand handlerCommand = null;
	private Connection connection = null;
	private List<String>artists=null;
	private String agent;
	private String message = null;

	public ClientUDP(String agent,List<String>artists) {
		
		try {
			
			this.connection = new Connection();
			
		} catch (SocketException e) {
			System.err.println(String.format("%s: %s",agent,e.getMessage()));
		}
		
		this.artists = artists;
		this.agent = agent;
		createInstances();
		
	}

	private void shuffleList() throws IOException{
		
		String server = null;
		String message = null;
		String del = null;
		String artist= null;
		int num = 0;
		
	
		System.out.printf("%s: procurando um servidor disponivel\n",agent);
		server = connection.testServers();
		
		del = sys.getDELIMITED_FIELD();
			
		if (server !=null){
			

			
			String hostD = server.split(del)[0];
			int portD = Integer.parseInt(server.split(del)[1]);
			System.out.printf("%s: o servidor %s:%s esta disponivel\n",agent,hostD,portD);
			int len = artists.size();

			
			// pega aleatoriamente um artista
			for (int i = 0; i < len   ; i++) {
				
				num  = (int) (Math.random() * len);
				artist = artists.get(num);
				message = String.format("%s:%s:%s","WHERE",artist,"C");
				System.out.println(String.format("%s: solicitando a discografia '%s' para %s:%s",agent,artist,hostD,portD));
				sendData(message, hostD, portD);
					
			}
				
		}else{
			System.err.printf("%s: nenhum servidor disponvel.\n",agent);	
		}
			
				
	
		
	}
	
	public void listenIt() {

		System.out.printf("%s: iniciando na porta %s.\n",agent,connection.getSocket().getLocalPort());
		
		try {
			
			shuffleList();
			
		} catch (IOException e) {
			System.err.printf("%s: %s%s%s\n",agent,"[",e.getMessage(),"]");
		}
		
		while (true) {
			
			try {
								
				receiveMessage = new UDPReceiveMessage();
				receiveMessage.setSocket(connection.getSocket());
				
				receiveMessage.receive();
				String hostD = receiveMessage.getPacket().getAddress().getHostName();
				int portD = receiveMessage.getPacket().getPort();
				message = receiveMessage.getTex();

				if (message != null) {

					lineCatch(message,String.format(":%s:%s", hostD, portD));

				}

			} catch (IOException e) {

				System.err.printf("%s: %s\n",agent,e.getMessage());

			}
		}

	}

	public void lineCatch(String message, String extra) {

		String del = sys.getDELIMITED_FIELD();

		if (message.contains(sys.getDELIMITED_FIELD())) {

			String cmd = message.split(del)[0];
			String arg = message.split(del)[1];
			String type = message.split(del)[2];
			String host = extra.split(del)[0];
			int port = Integer.parseInt(extra.split(del)[1]);

			try {

				handlerCommand = new HandlerCommand(cmd, arg, type, host, port);

			} catch (Exception e) {

				System.err.printf("%s: %s\n",agent,e.getMessage());

			}

		} else {
			
			System.out.printf("%s: comando mal formado %s\n",agent,message);
			
		}
	}
	
	private void sendData(String content,String host, int port){
		
		try {
			
			sendMessage = new UDPSendMessage(content.getBytes());
			sendMessage.setSocket(connection.getSocket()); 
			sendMessage.setPort(port);
			sendMessage.setInetAdress(host);
			sendMessage.send();
			
		} catch (Exception e) {
			System.out.printf("%s - erro ao enviar %s para %s:%s\n",agent,content,host,port);
		}
		
		
	}
	
	
	/**
	 * @return the agent
	 */

	public String getAgent() {
		return agent;
	}
	
	/**
	 * @param agent
	 *            the agent to set
	 */

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	private void createInstances(){
		this.sys = new SystemConfigurations();
	}
	
	/**
	 * @return the handlerCommand
	 */
	public HandlerCommand getHandlerCommand() {
		return handlerCommand;
	}
	
	public static void main(String[] args) {
		
		ClientUDP  clientUDP = null;
		List<String>listArtist = null;
		listArtist = new ArrayList<String>();
		
		listArtist.add("Adele");
		listArtist.add("Coldplay");
		listArtist.add("Avril Lavigne");
		listArtist.add("Bruno Mars");
		listArtist.add("Rihanna");
		listArtist.add("Pitty");
		listArtist.add("Nirvana");
		
		
		clientUDP = new ClientUDP("cliente",listArtist);
		clientUDP.listenIt();
		
		
	}

	
}