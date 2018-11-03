package Exercicio6_1;
/* 6. Strategy
6.1. Exercício:
Escreva um programa que exiba uma mensagem diferente para cada dia da semana usando
o padrão Strategy. */

/* Rodrigo Silva dos santos 
 * 816155559*/

public class TesteDiaDaSemana {

	public static void main(String[] args) {
		Semana semana = new Semana(new Quarta());
		semana.imprimeDia();
	}

}
