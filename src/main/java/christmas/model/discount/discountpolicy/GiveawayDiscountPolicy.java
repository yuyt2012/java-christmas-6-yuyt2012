package christmas.model.discount.discountpolicy;

import christmas.ProjectConstant;
import christmas.model.menu.Menu;
import java.util.HashMap;
import java.util.Map;

public class GiveawayDiscountPolicy {

    private final int totalPrice;

    public GiveawayDiscountPolicy(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static GiveawayDiscountPolicy of(int totalPrice) {
        return new GiveawayDiscountPolicy(totalPrice);
    }

    public Map<String, Integer> giveaway() {
        Map<String, Integer> giveMenu = new HashMap<>();
        if (minimumGiveawayPrice()) {
            giveMenu.put(Menu.CHAMPAGNE.getName(), 1);
            return giveMenu;
        }
        return giveMenu;
    }

    public boolean minimumGiveawayPrice() {
        if (totalPrice >= ProjectConstant.MINIMUM_GIVEAWAY_PRICE) {
            return true;
        }
        return false;
    }
}
