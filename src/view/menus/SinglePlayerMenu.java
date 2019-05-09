package view.menus;

import model.MenuType;

public class SinglePlayerMenu extends Menu {
    private static final SinglePlayerMenu SINGLE_PLAYER_MENU = new SinglePlayerMenu();
    private SinglePlayerMenu() {
    }
    public static SinglePlayerMenu getInstance() {
        return SINGLE_PLAYER_MENU;
    }


    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return null;
    }

    @Override
    public void open() {

    }
}
