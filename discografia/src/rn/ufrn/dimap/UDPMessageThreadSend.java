package rn.ufrn.dimap;

import java.net.DatagramSocket;

public class UDPMessageThreadSend extends UDPMessage implements Runnable {

	public UDPMessageThreadSend(DatagramSocket socket, String sender) {
		super(socket);
		super.setMessage(sender);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
}


