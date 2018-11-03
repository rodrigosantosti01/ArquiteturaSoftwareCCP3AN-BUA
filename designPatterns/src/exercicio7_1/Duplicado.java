package exercicio7_1;


public class Duplicado extends TransformacaoTemplate {

	@Override
	String transforma(String s) {
		return s + s;
	}

}
