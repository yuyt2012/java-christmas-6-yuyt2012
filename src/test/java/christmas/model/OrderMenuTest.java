package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenuTest {

    @DisplayName("유효한 메뉴 주문 생성")
    @Test
    void OrderMenu() {

        Map<String, Integer> menu = new HashMap<>();
        menu.put("해산물파스타", 2);

        OrderMenu orderMenu = new OrderMenu(menu);

        Assertions.assertThat(orderMenu.getMenu()).isEqualTo(menu);
    }
}