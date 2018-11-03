package exercicio4_2;

public class Teste {

	public static void main(String[] args) {
		SomadorEsperado somador = new SomadorAdapter();
		Cliente cliente = new Cliente(somador);
		cliente.executar();
	}

}
