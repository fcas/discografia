package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public final class DataUDP {

	private int port;
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private UDPSendMessage sendMessage = null;
	private SystemConfigurations sysConfig = null;
	private Scanner scan = null;
	private HandlerCommand handlerCommand = null; 
	private ConsoleMessage consoleMessage = null;
	
	public DataUDP (int port){
		this.port = port;
		this.scan = new Scanner(System.in);
		this.sysConfig = new SystemConfigurations();
		this.consoleMessage = new ConsoleMessage();
	}
	
	public void listenKB(){
		while(true) {
			
			System.out.println("PUT - Enviar discografia\n");
			String userMessage = scan.nextLine();			
			lineCatch(userMessage);	
		}
	}
	
	public void lineCatch(String linha){ 
		consoleMessage.setMessagem("Comando mal formado.");
		
		/* Procura o delimitador das mensagens */
		if (linha.contains(sysConfig.getDELIMITED_FIELD())){
				
			/* Obtendo os campos comando e argumento */
			String cmd = linha.split(sysConfig.getDELIMITED_FIELD())[0];
			String arg = linha.split(sysConfig.getDELIMITED_FIELD())[1];
			
			
			try {
				handlerCommand = new HandlerCommand(cmd, arg);
				
			} catch (Exception e) {
				consoleMessage.print();
			}
			
		} else {
			consoleMessage.setMessagem("Delimitador não encontrado");
			consoleMessage.print();
	      }
	}
	
	
	/**
	 * @param handlerCommand the handlerCommand to set
	 */
	public void setHandlerCommand(HandlerCommand handlerCommand) {
		this.handlerCommand = handlerCommand;
	}

	public static void main(String[] args) {
		
		try {
			DataUDP client = new DataUDP(1090);
			System.out.println("DataUDP inicializado.\n.");
			client.listenKB();
		} finally {
			
		}
	}
}