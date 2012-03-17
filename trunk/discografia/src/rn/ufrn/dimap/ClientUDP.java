package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClientUDP {

	private int port;
	private Request request = null;
	private UDPReceiveMessage receiveMessage = null;
	private UDPSendMessage sendMessage = null;
	private SystemConfigurations sysConfig = null;
	private Scanner scan = null;
	private HandlerCommand handlerCommand = null;
	private ConsoleMessage consoleMessage = null;
	private String artist;
	private String agent;

	public ClientUDP(String artist) {
		this.artist = artist;
		// enviando os dados
		try {
			handlerCommand = new HandlerCommand("WHERE", this.artist);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void listenIt() {

		String contentMessage;

		/*
		 * consoleMessage.setMessagem("Informa artista"); artist =
		 * scan.nextLine();
		 * 
		 * while(true) {
		 * 
		 * System.out.println("PUT - Enviar discografia\n"); String userMessage
		 * = scan.nextLine(); lineCatch(userMessage); }
		 */
		DatagramSocket s = null;

		try {
			s = new DatagramSocket(1090);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}

		while (true) {

			byte[] b = new byte[1024];

			// receiveMessage = new UDPReceiveMessage();
			// receiveMessage.setSocket(socket);
			DatagramPacket p;

			try {

				p = new DatagramPacket(b, b.length);
				s.receive(p);

				// receiveMessage.receive();
				contentMessage = new String(p.getData());
				// contentMessage = receiveMessage.getMessage();

				lineCatch(contentMessage);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void lineCatch(String linha) {
		consoleMessage.setMessagem("Comando mal formado.");

		/* Procura o delimitador das mensagens */
		if (linha.contains(sysConfig.getDELIMITED_FIELD())) {

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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Informe um artista");

		String artista = sc.nextLine();

		try {
			ClientUDP client = new ClientUDP(artista);
			System.out.println("Cliente inicializado.");
			client.listenIt();
		} finally {

		}
	}
}