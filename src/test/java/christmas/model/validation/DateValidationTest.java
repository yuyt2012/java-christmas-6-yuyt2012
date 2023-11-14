package christmas.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateValidationTest {

    @DisplayName("1보다 작은수 입력 금지")
    @Test
    void nonNegative() {
        int date = 0;
        DateValidation dateValidation = DateValidation.of(date);
        Assertions.assertThatThrownBy(() -> dateValidation.NonNegative(ExceptionMessage.OUT_OF_RANGE_DATE))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_DATE.getMessage());
    }

    @Test
    void outOfRange() {
        int min = 0;
        int max = 31;
        int date = 40;
        DateValidation dateValidation = DateValidation.of(date);
        Assertions.assertThatThrownBy(() -> dateValidation.OutOfRange(min, max, ExceptionMessage.OUT_OF_RANGE_DATE))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_DATE.getMessage());
    }
}