package domain.menu;

public class MenuItem implements IMenuItem{
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int cost() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
