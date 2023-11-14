package christmas.model.validation;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;

public class DateValidation {
    private int number;

    private DateValidation(int number) {
        this.number = number;
    }

    public static DateValidation of(int number) {
        return new DateValidation(number);
    }

    public DateValidation NonNegative(ExceptionMessage exceptionMessage) {
        if (number < 0) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }

    public DateValidation OutOfRange(int min, int max, ExceptionMessage exceptionMessage) {
        if (number < min || number > max) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }
}
