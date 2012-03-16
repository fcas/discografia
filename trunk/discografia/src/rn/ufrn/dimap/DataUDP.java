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
	
	public DataUDP (int port){
		this.port = port;
		this.scan = new Scanner(System.in);
		this.sysConfig = new SystemConfigurations();
	}
	
	public void listenKB(){
		while(true) {
			
			System.out.println("PUT - Enviar discografia\n");
			String userMessage = scan.nextLine();			
			lineCatch(userMessage);	
		}
	}
	
	public void lineCatch(String linha){
			
		/* Procura o delimitador das mensagens */
		if (linha.contains(sysConfig.getDELIMITED_FIELD())){
				
			/* Obtendo os campos comando e argumento */
			String cmd = linha.split(sysConfig.getDELIMITED_FIELD())[0];
			String arg = linha.split(sysConfig.getDELIMITED_FIELD())[1];
			HandlerCommand (cmd, arg);
		} else {
			System.out.printf("Comando mal formado: %s",linha);
	      }
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