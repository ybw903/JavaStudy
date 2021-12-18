package domain.menu;

import java.util.List;

public class Menu implements IMenu{

    private List<MenuItem> items;

    @Override
    public MenuItem choose(String name) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
