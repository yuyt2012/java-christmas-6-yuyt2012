package christmas.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuValidationTest {

    @DisplayName("메뉴에 없는 음식을 주문하면 예외발생")
    @Test
    void unavailableMenu() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("햄버거", 1);
        Assertions.assertThatThrownBy(() -> MenuValidation.of(menu)
                .unavailableMenu(ExceptionMessage.UNAVAILABLE_MENU))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.UNAVAILABLE_MENU.getMessage());
    }

    @DisplayName("최소 한개 이상의 주문을 해야함")
    @Test
    void minimumOrder() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("해산물파스타", 0);
        Assertions.assertThatThrownBy(() -> MenuValidation.of(menu)
                .minimumOrder(ExceptionMessage.MINIMUM_INPUT))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.MINIMUM_INPUT.getMessage());
    }

    @DisplayName("음료만 주문하면 예외 발생함")
    @Test
    void noOnlyDrink() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("제로콜라", 1);
        Assertions.assertThatThrownBy(() -> MenuValidation.of(menu)
                .noOnlyDrink(ExceptionMessage.UNAVAILABLE_MENU))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.UNAVAILABLE_MENU.getMessage());
    }

    @DisplayName("최대 주문개수")
    @Test
    void maxOrderCount() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("해산물파스타", 10);
        menu.put("제로콜라", 6);
        menu.put("초코케이크", 5);
        Assertions.assertThatThrownBy(() -> MenuValidation.of(menu)
                .maxOrderCount(ExceptionMessage.MAX_ORDER_MENU))
                .isInstanceOf(InputException.class)
                .hasMessage(ExceptionMessage.MAX_ORDER_MENU.getMessage());
    }
}