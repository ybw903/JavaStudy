package domain.coffee;

import domain.menu.MenuItem;

public class Coffee implements ICoffee{

    private String name;
    private int price;

    public Coffee(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.cost();
    }
}
