package rn.ufrn.dimap;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public final class DataUDP {

	private int port;
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private UDPSendMessage sendMessage = null;
	private HandlerCommand handlerCommand = null;
	private Connection connection = null;
	private SystemConfigurations sys = null;
	private List<String>listArtist = null;
	private String agent = null;

	/**
	 * Constroi o componente DataProvider 
	 * @param port
	 * @throws SocketException
	 */
	public DataUDP(int port,String agent, List<String>artists) {

		this.listArtist = artists;
		this.port = port;
		this.agent = agent;
		createInstances();
		 
	}

	/**
	 * Coloca o dataProvider 
	 * para receber as mensagens
	 */
	public void listenIt() {

		String message = null;
		System.out.printf("%s: iniciando na porta %s\n",agent,port);

		try {
			checkServers();
		} catch (IOException e) {
			System.err.printf("%s: %createInstancess%s%s\n",agent,"[",e.getMessage(),"]");
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

	private void checkServers() throws IOException{
		
		String del = sys.getDELIMITED_FIELD();
		String server = null;
				
		System.out.printf("%s: procurando um servidor disponivel\n",agent);
		server = connection.testServers();
		
		if (server !=null){
			
			String hostD = server.split(del)[0];
			int portD = Integer.parseInt(server.split(del)[1]);
			System.out.printf("%s: o servidor %s:%s esta disponivel\n",agent,hostD,portD);
			
			for (String artis : listArtist) {
				
				System.out.println(String.format("%s: enviando discografia '%s' para %s:%s",agent,artis,hostD,portD));
				String menssage = String.format("%s:%s:%s","PUT",artis,"D");
				sendData(menssage, hostD, portD);
				
			}
			
		}else{
			
			System.err.printf("%s: nenhum servidor esta disponivel.",agent);
			
		}
			
	}	
	
	/**
	 * Envia ma mensagem para 
	 * @param content
	 * @param host
	 * @param port
	 */
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
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}
	
	
	/**
	 * Cria as instancia do objentos necessarios
	 * no componente
	 * @throws SocketException
	 */
	private void createInstances(){
		
		try {
			
			this.sys = new SystemConfigurations();
			this.connection = new Connection(port); 
			listArtist = new ArrayList<String>();  
			
		} catch (IOException e) {
			System.err.printf("%s",e.getMessage());
		}
		
		
	}
	
	/**
	 * @return the handlerCommand
	 */
	public HandlerCommand getHandlerCommand() {
		return handlerCommand;
	}

	
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

	
	public static void main(String[] args) {
		
		List<String>listArtist = null;
		listArtist = new ArrayList<String>();
		
		listArtist.add("Adele");
		listArtist.add("Coldplay");
		listArtist.add("Avril Lavigne");
		listArtist.add("Bruno Mars");
		listArtist.add("Rihanna");
		listArtist.add("Pitty");
		listArtist.add("Nirvana");

		
		DataUDP dataProvider = new DataUDP(5051,"Data provider",listArtist);
		dataProvider.listenIt();
		
	}
	
}