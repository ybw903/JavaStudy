package domain.customer;

import domain.barista.Barista;
import domain.menu.Menu;

public interface ICustomer {
    // 인터페이스에서 메소드는?
    void order(String menuName, Menu menu, Barista barista);
}
