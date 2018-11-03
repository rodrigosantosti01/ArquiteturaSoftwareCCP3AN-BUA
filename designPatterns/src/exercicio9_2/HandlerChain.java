package exercicio9_2;



public interface HandlerChain {
	
	void setNextChain(HandlerChain nextChain);
	void handleRequest(int requisicao);

}
