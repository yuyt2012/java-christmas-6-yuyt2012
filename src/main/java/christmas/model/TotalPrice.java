package christmas.model;

import christmas.ProjectConstant;
import christmas.model.menu.Menu;
import java.util.Map;

public class TotalPrice {
    private final Map<String, Integer> menu;

    public TotalPrice(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public int price() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuNames = entry.getKey();
            Integer quantity = entry.getValue();
            int menuPrice = Menu.getPrice(menuNames);

            totalPrice += menuPrice * quantity;
        }
        return totalPrice;
    }

    public boolean minimumEvnetPrice() {
        int totalPrice = price();
        if (totalPrice >= ProjectConstant.MINIMUM_EVENT_PRICE) {
            return true;
        }
        return false;
    }
}
