package christmas.model.discount;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.TotalPrice;
import christmas.model.discount.discountpolicy.ChristmasDiscountPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPriceTest {
    int date = 3;
    Map<String, Integer> menu = new LinkedHashMap<>();
    TotalPrice totalPrice = new TotalPrice(menu);
    DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);

    @DisplayName("총 할인 금액 확인")
    @Test
    void totalDiscountPrice() {
        menu.put("티본스테이크", 2);
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 2);
        menu.put("아이스크림", 2);
        int result = discountPrice.christmasDiscountPrice() + discountPrice.weekdayDiscountPrice()
                + discountPrice.weekendDiscountPrice() + discountPrice.stardayDiscountPrice();
        Assertions.assertThat(result).isEqualTo(10292);
    }

    @DisplayName("총 혜택 금액 확인")
    @Test
    void totalBenefitPrice() {
        menu.put("티본스테이크", 2);
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 2);
        menu.put("아이스크림", 2);
        int result = discountPrice.christmasDiscountPrice() + discountPrice.weekdayDiscountPrice()
                + discountPrice.weekendDiscountPrice() + discountPrice.stardayDiscountPrice() + discountPrice.giveawayDiscountPrice();
        Assertions.assertThat(result).isEqualTo(35292);
    }

}