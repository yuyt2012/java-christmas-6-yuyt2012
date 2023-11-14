package christmas.model.discount.discountpolicy;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.menu.DessertMenu;
import christmas.model.menu.DrinkMenu;
import christmas.model.menu.Menu;
import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayDiscountPolicyTest {
    GiveawayDiscountPolicy giveawayDiscountPolicy = GiveawayDiscountPolicy.of(130_000);
    Map<String, Integer> menu = new LinkedHashMap<>();

    @DisplayName("메뉴를 넣어 제대로 작동하는지 확인")
    @Test
    void giveaway() {
        menu.put("티본스테이크", 2);
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 2);
        menu.put("아이스크림", 2);
        Map<String, Integer> result = giveawayDiscountPolicy.giveaway();
        Assertions.assertThat(result.keySet()).containsExactly(Menu.CHAMPAGNE.getName());
    }

    @DisplayName("최소 적용 금액 확인")
    @Test
    void minimumGiveawayPrice() {
        boolean result = giveawayDiscountPolicy.minimumGiveawayPrice();
        Assertions.assertThat(result).isTrue();
    }
}