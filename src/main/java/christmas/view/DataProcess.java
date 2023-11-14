package christmas.view;

import christmas.model.exception.ExceptionMessage;
import christmas.model.exception.InputException;
import christmas.model.exception.ProjectException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class DataProcess {
    public static int stringToIntConvertor(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public static Map<String, Integer> stringToMapConvertor(String input) {
        Map<String, Integer> menu = new HashMap<>();
        Set<String> checkDupNames = new HashSet<>();
        String[] menuItems = input.split(",");
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split("-");
            String menuName = parts[0].trim();
            if (!checkDupNames.add(menuName)) {
                throw new InputException(ExceptionMessage.UNAVAILABLE_MENU);
            }
            int quantity = Integer.parseInt(parts[1].trim());
            menu.put(menuName, quantity);
        }
        return menu;
    }

    public static <T> T retry(Supplier<T> supplier, boolean check) {
        while (true) {
            try {
                return supplier.get();
            } catch (ProjectException e) {
                System.out.println(e.getMessage());
                if (check) {
                    System.out.println();
                }
            }
        }
    }

    public static <T> T retry(Supplier<T> supplier) {
        return retry(supplier, false);
    }
}
