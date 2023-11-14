package christmas.model.menu;

public enum DrinkMenu {
    제로콜라("제로콜라", 3000),
    레드와인("레드와인", 60000),
    샴페인("샴페인", 25000);

    private final String name;
    private final int price;

    DrinkMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContain(String input) {
        for (DrinkMenu drinkMenu : DrinkMenu.values()) {
            if (drinkMenu.getName().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
