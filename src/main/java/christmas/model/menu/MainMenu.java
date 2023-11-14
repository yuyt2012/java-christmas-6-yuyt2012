package christmas.model.menu;

public enum MainMenu {
    티본스테이크("티본스테이크", 55000),
    바비큐립("바비큐립", 54000),
    해산물파스타("해산물파스타", 35000),
    크리스마스파스타("크리스마스파스타", 25000);

    private final String name;
    private final int price;

    MainMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContain(String input) {
        for (MainMenu mainMenu : MainMenu.values()) {
            if (mainMenu.getName().equalsIgnoreCase(input)) {
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
