package domain.customer;

import domain.barista.Barista;
import domain.coffee.Coffee;
import domain.menu.Menu;
import domain.menu.MenuItem;

public class Customer implements ICustomer{
    @Override
    public void order(String menuName, Menu menu, Barista barista) {
        MenuItem menuItem = menu.choose(menuName);
        Coffee coffee = barista.makeCoffee(menuItem);
    }
}
