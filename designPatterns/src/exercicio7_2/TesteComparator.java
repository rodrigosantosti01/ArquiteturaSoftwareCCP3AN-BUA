package exercicio7_2;

/*
Nome: Rodrigo silva dos santos 
R.A: 816155559 */


import java.util.Arrays;
import java.util.Comparator;

public class TesteComparator {
	
	public static void main(String[] args) {
		
		Double[] vetor = {1.12, 5.25, 7.23, 4.86, 9.21};
		
		Comparator<Double> comparator = new PontoFlutuanteComparator();
		
		Arrays.sort(vetor, comparator);
		
		System.out.println("Ordenado pelo ponto flutuante:");
		System.out.println(Arrays.toString(vetor));
		
		/*Ordenado pelo ponto flutuante:
		[1.12, 9.21, 7.23, 5.25, 4.86]*/
		
	}

}
