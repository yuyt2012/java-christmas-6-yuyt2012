package christmas.model;

import static christmas.model.exception.ExceptionMessage.*;

import christmas.model.validation.MenuValidation;
import java.util.Map;

public class OrderMenu {
    private final Map<String, Integer> menu;

    public OrderMenu(Map<String, Integer> menu) {
        validation(menu);
        this.menu = menu;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    private void validation(Map<String, Integer> menu) {
        menuValidation(menu);
    }

    private void menuValidation(Map<String, Integer> menu) {
        MenuValidation.of(menu)
                .minimumOrder(UNAVAILABLE_MENU)
                .unavailableMenu(UNAVAILABLE_MENU)
                .noOnlyDrink(UNAVAILABLE_MENU)
                .maxOrderCount(MAX_ORDER_MENU);
    }
}
