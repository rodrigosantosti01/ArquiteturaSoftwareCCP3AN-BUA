package Exercicio8_1;

public abstract class Noticiario {
	
	public abstract void notificaNoticia(String textoNoticia, int dia,
			int mes, String topico);
	
	public abstract void inscreverConsumidor(ConsomeNoticia consumidor);
	
	public abstract void removerConsumidor(ConsomeNoticia consumidor);
	
}