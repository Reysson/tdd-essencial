package pedidovenda;

public class QuantidadeItensInvalidaException extends RuntimeException {

    public QuantidadeItensInvalidaException() {
    }

    public QuantidadeItensInvalidaException(String message) {
        super(message);
    }

    public QuantidadeItensInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
