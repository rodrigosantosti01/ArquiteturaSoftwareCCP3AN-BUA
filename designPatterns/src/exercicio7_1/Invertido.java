package exercicio7_1;

public class Invertido extends TransformacaoTemplate {

	@Override
	String transforma(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}