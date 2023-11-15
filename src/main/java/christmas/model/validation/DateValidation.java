package christmas.model.validation;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;

public class DateValidation {
    private int date;

    private DateValidation(int date) {
        this.date = date;
    }

    public static DateValidation of(int number) {
        return new DateValidation(number);
    }

    public DateValidation NonNegative(ExceptionMessage exceptionMessage) {
        if (date < 1) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }

    public DateValidation OutOfRange(int min, int max, ExceptionMessage exceptionMessage) {
        if (date < min || date > max) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }
}
