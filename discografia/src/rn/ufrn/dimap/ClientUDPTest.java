package rn.ufrn.dimap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDPTest {
	public static void main(String[] args) {
		int porta = 1090;
        String servidor = "127.0.0.1";
       
                
        DatagramSocket s = null;
        
        try {
            s = new DatagramSocket(); /* Cria um socket UDP */
            System.out.println("\n* CLIENTE: Socket criado na porta: " + s.getLocalPort());
            InetAddress serv = InetAddress.getByName(servidor);
            String msg = String.format("%s:%s:%s:%s","GET","BANDA",servidor,s.getLocalPort());
            
            byte[] m = msg.getBytes(); /* Transforma msg em bytes */
            DatagramPacket req = new DatagramPacket(m, msg.length(), serv, porta);
            s.send(req); /* Envia datagrama contendo a mensagem m */
            System.out.println("* CLIENTE: request enviado: " + msg);
            
           /* byte[] buffer = new byte[1000];
            DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
            s.setSoTimeout(10000); // timeout em ms
            s.receive(resp); // aguarda resposta do servidor - bloqueante
            System.out.println("* CLIENTE: resposta do servidor:" + 
                    new String(resp.getData()).trim());*/
            
        } catch (Exception e) {
            System.out.println("! ERRO envio/recepcao do pacote: " + e.getMessage());
        }
        
	}	
}
