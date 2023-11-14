package christmas.model.menu;

public enum DessertMenu {
    초코케이크("초코케이크", 15000),
    아이스크림("아이스크림", 5000);

    private final String name;
    private final int price;

    DessertMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContain(String input) {
        for (DessertMenu dessertMenu : DessertMenu.values()) {
            if (dessertMenu.getName().equalsIgnoreCase(input)) {
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
