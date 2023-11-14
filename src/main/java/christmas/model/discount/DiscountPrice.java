package christmas.model.discount;

import christmas.model.TotalPrice;
import christmas.model.discount.discountpolicy.ChristmasDiscountPolicy;
import christmas.model.discount.discountpolicy.AweekDiscountPolicy;
import christmas.model.discount.discountpolicy.GiveawayDiscountPolicy;
import christmas.model.discount.discountpolicy.StarDayDiscountPolicy;
import christmas.model.menu.Menu;
import java.util.Map;

public class DiscountPrice {
    private final int date;
    private final Map<String, Integer> menu;
    private final TotalPrice totalPrice;

    public DiscountPrice(int date, Map<String, Integer> menu, TotalPrice totalPrice) {
        this.date = date;
        this.menu = menu;
        this.totalPrice = totalPrice;
    }

    public int totalDiscountPrice() {
        return christmasDiscountPrice() +
                weekdayDiscountPrice() +
                weekendDiscountPrice() +
                stardayDiscountPrice();
    }

    public int totalBenefitPrice() {
        return christmasDiscountPrice() +
                weekdayDiscountPrice() +
                weekendDiscountPrice() +
                stardayDiscountPrice() +
                giveawayDiscountPrice();
    }


    public int christmasDiscountPrice() {
        ChristmasDiscountPolicy christmasDiscountPolicy = ChristmasDiscountPolicy.of(date);
        return christmasDiscountPolicy.calculatorChristmasDiscount();
    }

    public int weekdayDiscountPrice() {
        AweekDiscountPolicy weekdayDiscountPolicy = AweekDiscountPolicy.of(date);
        return weekdayDiscountPolicy.calculatorWeekdayDiscount(menu);
    }

    public int weekendDiscountPrice() {
        AweekDiscountPolicy weekendDiscountPolicy = AweekDiscountPolicy.of(date);
        return weekendDiscountPolicy.calculatorWeekendDiscount(menu);
    }

    public int stardayDiscountPrice() {
        StarDayDiscountPolicy starDayDiscountPolicy = StarDayDiscountPolicy.of(date);
        return starDayDiscountPolicy.starDayDiscountPrice();
    }

    public int giveawayDiscountPrice() {
        GiveawayDiscountPolicy giveawayDiscountPolicy = GiveawayDiscountPolicy.of(totalPrice.price());
        if (giveawayDiscountPolicy.minimumGiveawayPrice()) {
            return Menu.CHAMPAGNE.getPrice();
        }
        return 0;
    }
}
