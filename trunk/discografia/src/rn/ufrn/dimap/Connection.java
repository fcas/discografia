package rn.ufrn.dimap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * O Verificador de conexoes com os servidores 
 * de discrografias, usado para dar um nível
 * de redundancia aos agentes da aplicacao
 */

public final class Connection {

	private String fileName = null;
	private InputStream isFile = null;
	private Scanner in = null;
	private DatagramSocket socket = null;
	private DatagramPacket sender = null;
	private DatagramPacket receiver = null;
	private String agent;
	private InetAddress address = null;
	private int timeOut=1000;
	private SystemConfigurations sysConfig=null;
	
	
	/**
	 * Constroi um objeto de teste de conexao
	 *  
	 * @param fileName arquivos contendo ip e portas do servidores
	 * principais
	 * 
	 * @param agent o nome do componente da aplicacao 
	 */
	
	public Connection(String fileName, String agent) {
		sysConfig = new SystemConfigurations();
		
		this.fileName = String.format("%s%s",sysConfig.getWorkDiretory(),
				sysConfig.getFileSeparator(),fileName);
		
		this.agent=agent;
		
		loadFile();
		checkServer();
	}
	
	/**
	 * Obtem o time de espera do socket
	 * @return timeOut o tempo  de espera do socket
	 */
	
	public int getTimeOut() {
		return timeOut;
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	/**
	 * Carrega o arquivo de ips de servidores
	 * de discografias
	 */
	
	private void loadFile(){
		
		try {
			isFile = new FileInputStream(String.format("%s",fileName));
		} catch (FileNotFoundException e) {
			// cria o objeto ConsoleMessage para imprimir o erro
			new ConsoleMessage(agent, e.getMessage());
		}
		
	}
	
	/**
	 * Tenta executar um teste de disponibilidade de servico
	 * para um componete da aplicacao
	 * @return address o endereco de algum sevidor disponivel
	 */
	
	private void checkServer(){
		
			if (this.isFile != null){
			
			try {
				
				this.in = new Scanner(this.isFile);
				while(in.hasNext()){
					
					String line = in.nextLine();
					String host = line.split(":")[0];				
					int port = Integer.parseInt(line.split(":")[1]);
					
					new ConsoleMessage(agent,
							String.format("tentando disponibilidade em %s:%s",
									host,port));
					address = getConnection(host, port);
					
					if (address != null)
						break;
					
				}	
				
			} catch (Exception ex) {
				/* Cria o objeto ConsoleMessage para imprimir o erro */
				new ConsoleMessage(agent, ex.getMessage());
			} finally{
				
				if (isFile != null){
					try {
						isFile.close();
					} catch (IOException e) {
						new ConsoleMessage(agent, e.getMessage());
					}
				}
			}	
		}	
	}
	
	public InetAddress getConnection(String host, int port){
		String message = "echo";
		byte[] buffer = message.getBytes();
		InetAddress address = null;
		
		try {
			
			socket = new DatagramSocket();
			socket.setSoTimeout(timeOut);

			sender = new DatagramPacket(buffer,buffer.length,
					InetAddress.getByName(host),port);
			socket.send(sender);
			
			receiver = new DatagramPacket(buffer, buffer.length);
			socket.receive(receiver);
			
			String retorn = new String(receiver.getData());
			
			if (retorn.equals(message))
				address = socket.getInetAddress();
			
		} catch (Exception e) {
			new ConsoleMessage(agent, e.getMessage()).outErro();
		}
		
		return address;
	}
	
}