package domain.barista;

import domain.coffee.Coffee;
import domain.menu.MenuItem;

public class Barista implements IBarista{
    @Override
    public Coffee makeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}
