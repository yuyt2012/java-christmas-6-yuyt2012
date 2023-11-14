package christmas.model.discount.discountpolicy;


import christmas.ProjectConstant;
import christmas.model.menu.DessertMenu;
import christmas.model.menu.MainMenu;
import java.time.LocalDate;
import java.util.Map;

public class AweekDiscountPolicy {
    private static final LocalDate EVENT_START_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH,
            ProjectConstant.START_DATE);
    private static final LocalDate EVENT_END_DAY = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH,
            ProjectConstant.END_DATE);

    private final LocalDate localDate;

    public AweekDiscountPolicy(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static AweekDiscountPolicy of(int date) {
        LocalDate inputDate = LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, date);
        return new AweekDiscountPolicy(inputDate);
    }

    public boolean isWeekday() {
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        if (dayOfWeek >= 1 && dayOfWeek <= 4 || dayOfWeek ==7) {
            return true;
        }
        return false;
    }

    public int calculatorWeekdayDiscount(Map<String, Integer> menu) {
        if (isWeekday()) {
            int weekdayDiscount = 0;
            return getDessertDiscount(menu, weekdayDiscount);
        }
        return 0;
    }

    public int calculatorWeekendDiscount(Map<String, Integer> menu) {
        if (!isWeekday()) {
            int weekendDiscount = 0;
            return getMainMenuDiscount(menu, weekendDiscount);
        }
        return 0;
    }

    private int getMainMenuDiscount(Map<String, Integer> menu, int weekendDiscount) {
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            if (MainMenu.isContain(menuName)) {
                weekendDiscount += (quantity * 2023);
            }
        }
        return weekendDiscount;
    }

    private int getDessertDiscount(Map<String, Integer> menu, int weekdayDiscount) {
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            if (DessertMenu.isContain(menuName)) {
                weekdayDiscount += (quantity * 2023);
            }
        }
        return weekdayDiscount;
    }
}
