package christmas.model.validation;

import christmas.ProjectConstant;
import christmas.model.menu.DrinkMenu;
import christmas.model.menu.Menu;
import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import java.util.Map;

public class MenuValidation {
    private final Map<String, Integer> menu;

    private MenuValidation(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public static MenuValidation of(Map<String, Integer> menu) {
        return new MenuValidation(menu);
    }

    public MenuValidation unavailableMenu(ExceptionMessage exceptionMessage) {
        for (String menuName : menu.keySet()) {
            if (!Menu.isContain(menuName)) {
                throw new InputException(exceptionMessage);
            }
        }
        return this;
    }

    public MenuValidation minimumOrder(ExceptionMessage exceptionMessage) {
        for (Integer quantity : menu.values()) {
            if (quantity < ProjectConstant.MIN_MENU) {
                throw new InputException(exceptionMessage);
            }
        }
        return this;
    }

    public MenuValidation noOnlyDrink(ExceptionMessage exceptionMessage) {
        boolean hasNonOnlyDrink = false;
        for (String menuName : menu.keySet()) {
            if (!DrinkMenu.isContain(menuName)) {
                hasNonOnlyDrink = true;
                break;
            }
        }
        if (!hasNonOnlyDrink) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }

    public MenuValidation maxOrderCount(ExceptionMessage exceptionMessage) {
        int orderCount = 0;
        for (Integer quantity : menu.values()) {
            orderCount += quantity;
        }
        if (orderCount > ProjectConstant.MAX_ORDER) {
            throw new InputException(exceptionMessage);
        }
        return this;
    }
}