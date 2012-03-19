package rn.ufrn.dimap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Cria e testar conexoes entre os diferentes agentes
 */
public final class Connection {

	private DatagramSocket socket = null;
	private DatagramPacket packetSend = null;
	private DatagramPacket packetReceive = null;
	private InetAddress address = null;
	private int timeOut;
	private int port;
	private SystemConfigurations sys = null;

	// usado para servidores
	public Connection(int port) throws SocketException {

		// abrindo a porta
		this.socket = new DatagramSocket(port);
		this.port = port;

	}

	// Uso do cliente e dataProvider se comunicarem
	public Connection(String host, int port) throws IOException {

		this.sys = new SystemConfigurations();
		this.socket = new DatagramSocket();
		this.address = InetAddress.getByName(host);
		this.port = port;
		this.timeOut = sys.getTIME_OUT();
		this.socket.setSoTimeout(this.timeOut);

	}

	// usado para clientes e dataProvider procurando um servidor disponivel
	public Connection(String host, int port, int timeOut)
			throws UnknownHostException, SocketException {

		this.address = InetAddress.getByName(host);
		this.sys = new SystemConfigurations();
		this.socket = new DatagramSocket();
		this.port = port;
		this.socket.setSoTimeout(timeOut);

	}

	public boolean testConenction(int count) throws IOException {

		byte[] buffer = sys.getDEFAULT_MESSAGE().getBytes();
		boolean successfull = false;
		String echo = null;

		packetSend = new DatagramPacket(buffer, buffer.length, address, port);
		packetReceive = new DatagramPacket(buffer, buffer.length);

		// faz um numero de tentativas determinada na classe
		// SystemConfigurations
		for (int i = 1; i <= count; i++) {
			
			System.out.print(String.format(
					"Realizando a %sº tentativa de comunicacao ", i));

			try {

				socket.send(packetSend);
				socket.receive(packetReceive);
				
				echo = new String(packetReceive.getData());
				 
				if (echo.equalsIgnoreCase(sys.getDEFAULT_MESSAGE())) {
					successfull = true;
					break;
				}
				
				
			} catch (Exception e) {
				System.out.println(String.format("[%s]", e.getMessage()));
			}

		}

		return successfull;

	}

	public String testServers() throws IOException {

		FileInputStream file = null;
		String server = null;

		sys = new SystemConfigurations();
		String fileName = String.format("%s%s%s", sys.getWorkDiretory(),
				sys.getFileSeparator(), sys.getCONFIG_FILE());

		file = loadFile(fileName);

		if (file != null) {

			Scanner in = new Scanner(file);

			// procura desesperadamente um servidor que possa atender
			while (in.hasNext()) {

				String line = in.nextLine();
				String host = line.split(sys.getDELIMITED_FIELD())[0];
				int port = Integer
						.parseInt(line.split(sys.getDELIMITED_FIELD())[1]);

				System.out.println(String.format(
						"Verificando disponibilidade  de %sº em porta %s",
						host, port));
				Connection connection = new Connection(host, port);

				if (connection.testConenction(3)) {
					server = line;
					break;
				}

			}

		}

		return server;

	}

	private FileInputStream loadFile(String fileName) {

		FileInputStream file = null;

		try {
			
			file = new FileInputStream(String.format("%s", fileName));
			
		} catch (FileNotFoundException e) {
			
			System.err.println(String.format("%s", e.getMessage()));
			
		} finally {
			
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.err.println(String.format("%s", e.getMessage()));
				}
			}
		}

		return file;

	}

	/**
	 * @return the socket
	 */
	public DatagramSocket getSocket() {
		return socket;
	}

	/**
	 * @return the address
	 */
	public InetAddress getAddress() {
		return address;
	}

}