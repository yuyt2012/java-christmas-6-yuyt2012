package christmas.model.discount.discountpolicy;

import christmas.ProjectConstant;
import java.time.LocalDate;

public class ChristmasDiscountPolicy {
    private static final LocalDate EVENT_START_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, ProjectConstant.START_DATE);
    private static final LocalDate EVENT_END_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, ProjectConstant.CHRISTMAS);

    private final LocalDate localDate;

    private ChristmasDiscountPolicy(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static ChristmasDiscountPolicy of(int date) {
        LocalDate inputDate = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, date);
        return new ChristmasDiscountPolicy(inputDate);
    }

    private boolean isChristmasEvent() {
        return !localDate.isBefore(EVENT_START_DAY) && !localDate.isAfter(EVENT_END_DAY);
    }

    public int calculatorChristmasDiscount() {
        if (isChristmasEvent()) {
            int initDiscountMoney = 1000;
            int discountIncreasePerDay = 100;
            long untilChristmas = EVENT_START_DAY.until(localDate).getDays();
            return Math.max(initDiscountMoney + (int) (untilChristmas * discountIncreasePerDay), 0);
        }
        return 0;
    }
}
