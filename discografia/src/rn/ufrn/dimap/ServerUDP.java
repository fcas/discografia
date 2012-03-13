package rn.ufrn.dimap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
	public static void main(String args[]) throws SocketException {
		
        DatagramSocket s = null;
        
        s = new DatagramSocket(6789);
        System.out.printf("Servidor: aguardando pedido na porta %s\n",s.getPort());
        
        while(true){
        
	        try {
	            
	            byte[] buffer = new byte[1000];
	            DatagramPacket req = new DatagramPacket(buffer, buffer.length);
	            s.receive(req);
	            System.out.println("Servidor: recebeu: " 
	            + req.getAddress()
	            +":"+req.getPort() 
	            + " " + new String(req.getData()));
	            
	            // envia resposta
	            DatagramPacket resp = new DatagramPacket(req.getData(), req.getLength(),
	                    req.getAddress(), req.getPort());
	            s.send(resp);
	        } catch (SocketException e) {
	            System.out.println("Erro de socket: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("Erro envio/recepcao pacote: " + e.getMessage());
	        } finally {}
        }
    }
	
}
