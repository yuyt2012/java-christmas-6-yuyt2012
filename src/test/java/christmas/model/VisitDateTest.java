package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDateTest {

    @DisplayName("방문날짜 생성")
    @Test
    void validVisitDate() {
        int date = 20;

        VisitDate visitDate = new VisitDate(date);

        Assertions.assertThat(visitDate.getDate()).isEqualTo(date);
    }
}