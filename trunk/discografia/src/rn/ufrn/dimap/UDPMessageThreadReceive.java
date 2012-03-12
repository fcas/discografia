package rn.ufrn.dimap;

import java.net.DatagramSocket;

public class UDPMessageThreadReceive extends UDPMessage implements Runnable {

	public UDPMessageThreadReceive(DatagramSocket socket) {
		super(socket);
	}

	@Override
	public void run() {
		
	}

}
