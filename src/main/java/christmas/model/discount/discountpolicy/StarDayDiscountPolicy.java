package christmas.model.discount.discountpolicy;

import christmas.ProjectConstant;
import christmas.model.StarDay;
import java.time.LocalDate;

public class StarDayDiscountPolicy {
    private static final LocalDate EVENT_START_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH,
            ProjectConstant.START_DATE);
    private static final LocalDate EVENT_END_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH,
            ProjectConstant.END_DATE);

    private final LocalDate localDate;

    public StarDayDiscountPolicy(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static StarDayDiscountPolicy of(int date) {
        LocalDate inputDate = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, date);
        return new StarDayDiscountPolicy(inputDate);
    }

    private boolean isStarDay() {
        for (StarDay starDay : StarDay.values()) {
            if (localDate.equals(starDay.getDate())) {
                return true;
            }
        }
        return false;
    }

    public int starDayDiscountPrice() {
        if (isStarDay()) {
            return 1000;
        }
        return 0;
    }
}
