package christmas.view.inputview;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import christmas.view.DataProcess;
import java.util.Map;
import java.util.regex.Pattern;

public class InputMenu extends InputView {
    private static final String MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final Pattern PATTERN1 = Pattern.compile("([가-힣A-Za-z0-9]+-\\d+)(,([가-힣A-Za-z0-9]+-\\d+))*");

    public Map<String, Integer> readMenu() {
        System.out.println(MESSAGE);
        String menu = inputData();
        validation(menu);
        return DataProcess.stringToMapConvertor(menu);
    }

    private void validation(String menu) {
        menuValidation(menu);
    }

    private void menuValidation(String menu) {
        if (!PATTERN1.matcher(menu).matches()) {
            throw new InputException(ExceptionMessage.INVALID_FORMAT);
        }
    }
}
