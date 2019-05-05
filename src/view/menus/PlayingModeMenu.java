package view.menus;

import model.MenuType;

public class PlayingModeMenu extends Menu{
    private static final PlayingModeMenu PLAYING_MODE_MENU = new PlayingModeMenu();
    private PlayingModeMenu() {
    }
    public static PlayingModeMenu getInstance() {
        return PLAYING_MODE_MENU;
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.PLAYING_MODE_MENU;
    }
}
