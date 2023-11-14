package christmas.model.discount.discountpolicy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AweekDiscountPolicyTest {
    Map<String, Integer> menu = new LinkedHashMap<>();

    @DisplayName("입력받은 날짜가 평일이면 True, 주말이면 False")
    @Test
    void isWeekday() {
        AweekDiscountPolicy aweekDiscountPolicy = AweekDiscountPolicy.of(20);
        boolean weekday = aweekDiscountPolicy.isWeekday();
        Assertions.assertThat(weekday).isTrue();
    }

    @DisplayName("평일 할인적용")
    @Test
    void calculatorWeekdayDiscount() {
        menu.put("티본스테이크", 2);
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 2);
        menu.put("아이스크림", 2);
        AweekDiscountPolicy aweekDiscountPolicy = AweekDiscountPolicy.of(20);
        int result = aweekDiscountPolicy.calculatorWeekdayDiscount(menu);
        Assertions.assertThat(result).isEqualTo(8092);

    }

    @DisplayName("주말 할인적용")
    @Test
    void calculatorWeekendDiscount() {
        menu.put("티본스테이크", 2);
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 2);
        menu.put("아이스크림", 2);
        AweekDiscountPolicy aweekDiscountPolicy = AweekDiscountPolicy.of(8);
        int result = aweekDiscountPolicy.calculatorWeekendDiscount(menu);
        Assertions.assertThat(result).isEqualTo(8092);
    }
}