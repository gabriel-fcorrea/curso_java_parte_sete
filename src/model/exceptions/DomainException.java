package model.exceptions;

//Runtime tira a exigibilidade de propagação através do throws 
public class DomainException extends RuntimeException {
	// versão de uma classe serializible
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg); // repasse da mensagem para o construtor da superclasse para possibilitar a
					// instanciação passando uma mensagem da exceção personalizada
	}

}
