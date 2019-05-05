package view.menus;

import controller.PlayController;
import model.MenuType;

public abstract class Menu {
    public abstract void help();
    public abstract MenuType getType();

    public void exit() {
        PlayController.menus.remove(PlayController.menus.size() - 1);
    }
}
