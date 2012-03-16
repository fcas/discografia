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
			handlerCommand(cmd, arg);
		} else {
			System.out.printf("Comando mal formado: %s",linha);
	      }
	}
	
	public void handlerCommand(String cmd, String arg){
		
		Commands enumCommand;
		
		/* A ordem da cadeia eh importante */
		Handler handlerGet = new HandlerGetCommand();
		Handler handlerData = new HandlerDataCommand();
		Handler handlerDisco = new HandlerDiscoCommand();
		Handler handlerEcho = new HandlerEchoCommand();
		
		handlerGet.setSucessor(handlerData);
		handlerData.setSucessor(handlerDisco);
		handlerDisco.setSucessor(handlerEcho);
		
		try {
		
			enumCommand = Commands.valueOf(cmd);
			request = new Request(enumCommand, arg);
			handlerGet.handleRequest(request);
			
			
		} catch (Exception e) {
			System.out.printf("Comando nao implementado: %s",cmd);
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			ClientShow client = new ClientShow(1090);
			System.out.println("Cliente inicializado.\n Bem-vindo, usuario.");
			client.listenKB();
		} finally {
			
		}
	}
}