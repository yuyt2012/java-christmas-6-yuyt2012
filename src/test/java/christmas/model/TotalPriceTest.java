package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.menu.Menu;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalPriceTest {

    @DisplayName("총 주문 가격")
    @Test
    void price() {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("해산물파스타", 2);
        menu.put("초코케이크", 1);

        TotalPrice totalPriceCalculator = new TotalPrice(menu);

        int totalPrice = totalPriceCalculator.price();

        Assertions.assertThat(totalPrice).isEqualTo(Menu.getPrice("해산물파스타") * 2
                + Menu.getPrice("초코케이크"));
    }
}