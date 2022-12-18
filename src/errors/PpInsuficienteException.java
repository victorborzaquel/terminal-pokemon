package errors;

public class PpInsuficienteException extends Exception {
    public PpInsuficienteException(String message) {
        super(message);
    }

    public PpInsuficienteException() {
        super("PP insuficiente");
    }
}
