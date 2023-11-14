package christmas.view.outputview;

import static christmas.view.outputview.OutViewConstant.*;

import christmas.ProjectConstant;
import christmas.model.discount.DiscountPrice;
import christmas.model.Grade;
import christmas.model.VisitDate;
import christmas.model.OrderMenu;
import christmas.model.TotalPrice;
import christmas.model.discount.discountpolicy.AweekDiscountPolicy;
import christmas.model.discount.discountpolicy.GiveawayDiscountPolicy;
import java.util.Map;

public class OutputView {

    public static void printPreface() {
        System.out.printf(PREFACE, ProjectConstant.MONTH);
    }

    public static void printOrderMenu(OrderMenu orderMenu, VisitDate visitDate) {
        System.out.printf(NOTICE, ProjectConstant.MONTH, visitDate.getDate());
        System.out.println();
        System.out.printf(ORDER_MENU);
        Map<String, Integer> menu = orderMenu.getMenu();
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%s %d개", menuName, quantity);
            System.out.println();
        }
        System.out.println();
    }

    public static void printBeforePrice(Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        System.out.printf(BEFORE_TOTAL_PRICE);
        System.out.printf(String.format("%,d원\n", totalPrice.price()));
        System.out.println();
    }

    public static void printGiveaway(int totalPrice) {
        GiveawayDiscountPolicy giveawayDiscountPolicy = GiveawayDiscountPolicy.of(totalPrice);
        System.out.printf(GIVEAWAY);
        Map<String, Integer> giveaway = giveawayDiscountPolicy.giveaway();
        if (!giveaway.isEmpty()) {
            for (Map.Entry<String, Integer> entry : giveaway.entrySet()) {
                String menuName = entry.getKey();
                int quantity = entry.getValue();
                System.out.printf("%s %d개\n", menuName, quantity);
                System.out.println();
            }
        }
        if (giveaway.isEmpty()) {
            System.out.printf(NOTHING);
            System.out.println();
        }
    }

    public static void printBenefit(int date, Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        System.out.printf(BENEFIT);
        if (!totalPrice.minimumEvnetPrice()) {
            System.out.printf(NOTHING);
            System.out.println();
        }
        if (totalPrice.minimumEvnetPrice()) {
            printChristmasPrice(date, menu);
            printAweekPrice(date, menu);
            printStardayPrice(date, menu);
            printGiveawayPrice(date, menu);
            System.out.println();
        }
    }

    private static void printChristmasPrice(int date, Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        if (discountPrice.christmasDiscountPrice() != 0) {
            System.out.printf(String.format(CHRISTMAS_DISCOUNT, discountPrice.christmasDiscountPrice() * -1));
        }
    }

    private static void printAweekPrice(int date, Map<String, Integer> menu) {
        AweekDiscountPolicy aweekDiscountPolicy = AweekDiscountPolicy.of(date);
        TotalPrice totalPrice = new TotalPrice(menu);
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        if (aweekDiscountPolicy.isWeekday()) {
            if (discountPrice.weekdayDiscountPrice() != 0) {
                System.out.printf(String.format(WEEKDAY_DISCOUNT, discountPrice.weekdayDiscountPrice() * -1));
            }
        }
        if (!aweekDiscountPolicy.isWeekday()) {
            if (discountPrice.weekendDiscountPrice() != 0) {
                System.out.printf(String.format(WEEKEND_DISCOUNT, discountPrice.weekendDiscountPrice() * -1));
            }
        }
    }

    private static void printStardayPrice(int date, Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        if (discountPrice.stardayDiscountPrice() != 0) {
            System.out.printf(String.format(STARDAY_DISCOUNT, discountPrice.stardayDiscountPrice() * -1));
        }
    }

    private static void printGiveawayPrice(int date, Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        if (discountPrice.giveawayDiscountPrice() != 0) {
            System.out.printf(String.format(GIVEAWAY_DISCOUNT, discountPrice.giveawayDiscountPrice() * -1));
        }
    }

    public static void printTotalBenefitPrice(int date, Map<String, Integer> menu) {
        TotalPrice totalPrice = new TotalPrice(menu);
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        System.out.printf(TOTAL_BENEFIT_PRICE);
        if (!totalPrice.minimumEvnetPrice()) {
            System.out.printf("%d원\n", 0);
            System.out.println();
        }
        if (totalPrice.minimumEvnetPrice()) {
            System.out.printf(String.format(TOTAL_DISCOUNT, discountPrice.totalBenefitPrice() * -1));
            System.out.println();
        }
    }

    public static void printExpectPayment(int date, Map<String, Integer> menu, TotalPrice totalPrice) {
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        System.out.printf(EXPECT_PAYMENT);
        if (totalPrice.minimumEvnetPrice()) {
            System.out.printf(
                    String.format(EXPECT_PAYMENT_PRICE, totalPrice.price() - discountPrice.totalDiscountPrice()));
            System.out.println();
        }
        if (!totalPrice.minimumEvnetPrice()) {
            System.out.printf(String.format(EXPECT_PAYMENT_PRICE, totalPrice.price()));
            System.out.println();
        }
    }

    public static void printEventBadge(int date, Map<String, Integer> menu, TotalPrice totalPrice) {
        DiscountPrice discountPrice = new DiscountPrice(date, menu, totalPrice);
        System.out.printf(EVENT_BADGE);
        System.out.printf(Grade.getGrade(discountPrice.totalBenefitPrice()).toString());
    }
}
