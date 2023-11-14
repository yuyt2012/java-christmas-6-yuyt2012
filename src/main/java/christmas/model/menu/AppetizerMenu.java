package christmas.model.menu;

public enum AppetizerMenu {
    양송이수프("양송이수프", 6000),
    타파스("타파스", 5500),
    시저샐러드("시저샐러드", 8000);

    private final String name;
    private final int price;

    AppetizerMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContain(String input) {
        for (AppetizerMenu appetizerMenu : AppetizerMenu.values()) {
            if (appetizerMenu.getName().equalsIgnoreCase(input)) {
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
