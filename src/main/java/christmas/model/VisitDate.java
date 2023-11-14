package christmas.model;

import christmas.ProjectConstant;
import christmas.model.exception.ExceptionMessage;
import christmas.model.validation.DateValidation;

public class VisitDate {
    private final int date;

    public VisitDate(int date) {
        validation(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    private void validation(int date) {
        DateValidation(date);
    }

    private void DateValidation(int date) {
        DateValidation.of(date)
                .NonNegative(ExceptionMessage.OUT_OF_RANGE_DATE)
                .OutOfRange(ProjectConstant.START_DATE, ProjectConstant.END_DATE, ExceptionMessage.OUT_OF_RANGE_DATE);
    }
}
