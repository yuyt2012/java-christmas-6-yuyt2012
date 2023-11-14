package christmas.controller;

import static christmas.view.outputview.OutputView.printBeforePrice;
import static christmas.view.outputview.OutputView.printBenefit;
import static christmas.view.outputview.OutputView.printEventBadge;
import static christmas.view.outputview.OutputView.printExpectPayment;
import static christmas.view.outputview.OutputView.printGiveaway;
import static christmas.view.outputview.OutputView.printOrderMenu;
import static christmas.view.outputview.OutputView.printPreface;
import static christmas.view.outputview.OutputView.printTotalBenefitPrice;

import christmas.model.VisitDate;
import christmas.model.OrderMenu;
import christmas.model.TotalPrice;
import christmas.view.DataProcess;
import christmas.view.inputview.InputDate;
import christmas.view.inputview.InputMenu;
import java.util.Map;

public class ProjectController {
    public void run() {
        printPreface();
        VisitDate date = getDate();
        OrderMenu orderMenu = getOrderMenu();
        printOrderMenu(orderMenu, date);
        printBeforePrice(orderMenu.getMenu());
        TotalPrice totalPrice = getTotalPrice(orderMenu.getMenu());
        printGiveaway(totalPrice.price());
        printBenefit(date.getDate(), orderMenu.getMenu());
        printTotalBenefitPrice(date.getDate(), orderMenu.getMenu());
        printExpectPayment(date.getDate(), orderMenu.getMenu(), totalPrice);
        printEventBadge(date.getDate(), orderMenu.getMenu(), totalPrice);
    }

    private VisitDate getDate() {
        return DataProcess.retry(() -> {
            return new VisitDate(new InputDate().readDate());
        }, true);
    }

    private OrderMenu getOrderMenu() {
        return DataProcess.retry(() -> {
            return new OrderMenu(new InputMenu().readMenu());
        }, true);
    }

    private TotalPrice getTotalPrice(Map<String, Integer> menu) {
        return new TotalPrice(menu);
    }
}
