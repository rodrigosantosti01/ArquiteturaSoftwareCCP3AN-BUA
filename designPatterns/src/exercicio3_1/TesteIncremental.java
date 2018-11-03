package exercicio3_1;

/*
Nome: Rodrigo silva dos santos 
R.A: 816155559 */

public class TesteIncremental {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Incremental inc = Incremental.getInstanceOff();
			inc.incrementa();
			System.out.println(inc);
		}
	}
	
}
