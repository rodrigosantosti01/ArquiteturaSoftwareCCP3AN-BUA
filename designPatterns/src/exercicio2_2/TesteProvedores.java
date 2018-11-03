package exercicio2_2;

/*
Nome: Rodrigo silva dos santos 
R.A: 816155559 */

public class TesteProvedores {
	
	public static void main(String[] args) {
		
		FactoryProvedor provFact = new FactoryProvedor();
		
		// Confidencial
		Provedor provedor = provFact.getProvedor("design patterns");
		provedor.exibir();
		
		// Publico
		provedor = provFact.getProvedor();
		provedor.exibir();
		
	}

}
