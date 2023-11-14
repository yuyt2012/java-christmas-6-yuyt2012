package christmas.view.inputview;

import christmas.ProjectConstant;
import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import christmas.model.validation.DateValidation;
import christmas.view.DataProcess;
import java.util.regex.Pattern;

public class InputDate extends InputView {
    private static final String MESSAGE = "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public int readDate() {
        System.out.printf(MESSAGE, ProjectConstant.MONTH);
        System.out.println();
        String date = inputData();
        validation(date);
        return DataProcess.stringToIntConvertor(date);
    }

    private void validation(String date) {
        dataValidation(date);
    }

    private void dataValidation(String date) {
        if (!PATTERN.matcher(date).matches()) {
            throw new InputException(ExceptionMessage.OUT_OF_RANGE_DATE);
        }
        int parsedDate = DataProcess.stringToIntConvertor(date);
        DateValidation.of(parsedDate).NonNegative(ExceptionMessage.OUT_OF_RANGE_DATE);
    }
}
