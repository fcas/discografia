package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public final class ClientShow {

	private int port;
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private UDPSendMessage sendMessage = null;
	private SystemConfigurations sysConfig = null;
	private Scanner scan = null;
	
	
	
	public ClientShow (int port){
		this.port = port;
		this.scan = new Scanner(System.in);
		this.sysConfig = new SystemConfigurations();
	}
	
	public void listenKB(){
		while(true) {
			
			System.out.println("QUIT - sair do programa\nGET:<artista> - procurar discografia");
			String userMessage = scan.nextLine();
			
			if (userMessage != "QUIT"){
				lineCatch(userMessage);
			}
			else {
				System.out.println("Saindo do programa. Ate a proxima.");
				break;
			}
			
		}
	}
	
	public void lineCatch(String linha){
			
			// procura o delimitador das mensagens
			if (linha.contains(sysConfig.getDELIMITED_FIELD())){
				
				// obtendo os campos comando e argumento
				String cmd = linha.split(sysConfig.getDELIMITED_FIELD())[0];
				String arg = linha.split(sysConfig.getDELIMITED_FIELD())[1];
				handlerCommand(cmd, arg);
				
			}else{
				System.out.printf("Comando mal formado: %s",linha);
			}
			
		}
	
	
	
	public void handlerCommand(String cmd, String arg){
		
		Commands enumCommand;
		
		// a ordem da cadei he importante
		Handler handlerGet = new HandlerGetCommand();
		Handler handlerData = new HandlerDataCommand();
		Handler handlerDisco = new HandlerDiscoCommand();
		Handler handlerEcho = new HandlerEchoCommand();
		
		handlerGet.setSucessor(handlerData);
		handlerData.setSucessor(handlerDisco);
		handlerDisco.setSucessor(handlerEcho);
		//		
		
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
