package domain.barista;

import domain.coffee.Coffee;
import domain.menu.MenuItem;

public interface IBarista {
    Coffee makeCoffee(MenuItem menuItem);
}
