package view.menus;

import model.MenuType;

public class MainMenu extends Menu {
    private static final MainMenu MAIN_MENU = new MainMenu();
    private MainMenu() {
    }
    public static MainMenu getInstance() {
        return MAIN_MENU;
    }

    @Override
    public void help() {
        System.out.print("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Help");
    }

    @Override
    public MenuType getType() {
        return MenuType.MAIN_MENU;
    }

}
