package exercicio7_1;
/*
Nome: Rodrigo silva dos santos 
R.A: 816155559 */

public class TesteTransformacao {
	
	public static void main(String[] args) {
		
		TransformacaoTemplate transf = new Maiusculo();
		transf.processo();
		
		transf = new Minusculo();
		transf.processo();
		
		transf = new Duplicado();
		transf.processo();
		
		transf = new Invertido();
		transf.processo();
		
		/*Insira a string: teste
		TESTE
		Insira a string: teste
		teste
		Insira a string: teste
		testeteste
		Insira a string: teste
		etset*/
		
	}

}
