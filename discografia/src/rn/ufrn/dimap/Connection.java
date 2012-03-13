package rn.ufrm.dimap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Connection {

	private String separator = null;
	private String fileName = null;
	private InputStream fileIn=null;
	private Scanner in=null;
	private String ip=null;
	private int port;
	private DatagramSocket socket=null;
	private DatagramPacket sender=null;
	private DatagramPacket receiver=null;
	private String agent;
	private InetAddress addr;
	
	
	
	public Connection(String fileName, String agent) {
		this.fileName = fileName;
		this.agent=agent;
		
		loadFile();
		
		
	}
	
	private void loadFile(){
		
		try {
			this.fileIn = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public  InetAddress getConnection(){
		
		String line;				
		String ip;
		int port;
		
		if (this.fileIn !=null){
			
			this.in = new Scanner(this.fileIn);
			
			while(in.hasNext()){
				line = in.nextLine();
				ip = line.split(":")[0];
				port = Integer.parseInt(line.split(":")[1]);
				
			}
			
			
		}
		
		return null;
	}
	
	
	
	
	
}
