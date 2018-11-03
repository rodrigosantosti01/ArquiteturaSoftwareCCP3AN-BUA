package exercicio2_3;
/*
Nome: Rodrigo silva dos santos 
R.A: 816155559 */

public class TesteLog {
	
	public static void main(String[] args) {
		
		// "Contando at� 10"
		int[] numeros = new int[10];
		for (int i = 0; i < 10; i++) {
			numeros[i] = i + 1;
		}
		
		LogFactory logfact = new LogFactory();
		
		Log log = logfact.getLog("arquivo");
		log.efetuar(numeros);
		
		log = logfact.getLog("console");
		log.efetuar(numeros);
		
	}

}
