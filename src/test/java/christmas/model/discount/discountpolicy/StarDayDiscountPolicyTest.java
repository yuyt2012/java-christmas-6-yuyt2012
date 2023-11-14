package christmas.model.discount.discountpolicy;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StarDayDiscountPolicyTest {

    @DisplayName("입력받은 날짜가 특별한 날인지 확인")
    @Test
    void starDayDiscountPrice() {
        StarDayDiscountPolicy starDayDiscountPolicy = StarDayDiscountPolicy.of(10);
        int result = starDayDiscountPolicy.starDayDiscountPrice();
        Assertions.assertThat(result).isEqualTo(1000);
    }
}