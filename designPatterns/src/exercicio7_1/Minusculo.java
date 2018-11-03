package exercicio7_1;


public class Minusculo extends TransformacaoTemplate {

	@Override
	String transforma(String s) {
		return s.toLowerCase();
	}

}
