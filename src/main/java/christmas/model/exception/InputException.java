package christmas.model.exception;

public class InputException extends ProjectException {
    public InputException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
