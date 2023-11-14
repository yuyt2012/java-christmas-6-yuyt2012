package christmas.model.discount.discountpolicy;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDiscountPolicyTest {

    @DisplayName("12월 1일부터 25일 사이에 사용자가 입력한 날짜의 기간동안 할인 적용")
    @Test
    void calculatorChristmasDiscount() {
        ChristmasDiscountPolicy christmasDiscountPolicy = ChristmasDiscountPolicy.of(3);
        int result = christmasDiscountPolicy.calculatorChristmasDiscount();
        Assertions.assertThat(result).isEqualTo(1200);
    }
}