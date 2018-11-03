package exercicio7_1;

public class Maiusculo extends TransformacaoTemplate {

	@Override
	String transforma(String s) {
		return s.toUpperCase();
	}

}
