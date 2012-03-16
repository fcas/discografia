package rn.ufrn.dimap;

public void class HandlerCommand (){
	
	private Request request = null;
	
	public void handlercommand (String cmd, String arg) {

	Commands enumCommand;
		
	Handler handlerGet = new HandlerGetCommand();
	Handler handlerData = new HandlerDataCommand();
	Handler handlerDisco = new HandlerDiscoCommand();
	Handler handlerEcho = new HandlerEchoCommand();
	Handler handlerPut = new HandlerPutCommand();
	
	handlerGet.setSucessor(handlerData);
	handlerData.setSucessor(handlerDisco);
	handlerDisco.setSucessor(handlerEcho);
	handlerEcho.setSucessor(handlerPut);
	
	try {
		
		enumCommand = Commands.valueOf(cmd);
		request = new Request(enumCommand, arg);
		handlerGet.handleRequest(request);
		
	} catch (Exception e) {
		System.out.printf("Comando nao implementado: %s",cmd);
	}
  }
}