package errors;

public class PPInsuficienteException extends Exception {
    public PPInsuficienteException(String message) {
        super(message);
    }

    public PPInsuficienteException() {
        super("PP insuficiente");
    }
}
