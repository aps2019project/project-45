package view.menus;

import controller.PlayController;
import model.MenuType;

public class MainMenu extends Menu {
    private static final MainMenu MAIN_MENU = new MainMenu();
    private MainMenu() {
    }
    public static MainMenu getInstance() {
        return MAIN_MENU;
    }

    public void enterCollection() {
        PlayController.menus.add(new PlayerCollection());
    }
    public void enterShop() {
        PlayController.menus.add(Shop.getInstance());
    }
    public void enterPlayingTypeMenu() {
        PlayController.menus.add(PlayingTypeMenu.getInstance());
    }

    @Override
    public void help() {
        System.out.print("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Help\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.MAIN_MENU;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Main Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

}
