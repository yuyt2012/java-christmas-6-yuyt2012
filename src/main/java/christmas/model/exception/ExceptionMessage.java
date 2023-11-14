package christmas.model.exception;

public enum ExceptionMessage {
    OUT_OF_RANGE_DATE(" 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_INPUT(" 숫자만 입력할 수 있습니다. 다시 입력해 주세요."),
    UNAVAILABLE_MENU(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MINIMUM_INPUT(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_FORMAT(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_MENU(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MAX_ORDER_MENU(" 한번에 주문 가능한 수는 최대 20입니다. 다시 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
