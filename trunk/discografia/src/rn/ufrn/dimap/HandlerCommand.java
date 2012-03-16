package rn.ufrn.dimap;

public class HandlerCommand {

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
