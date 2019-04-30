package view;

import controller.PlayController;

public abstract class Menus {
    public abstract void help();
    public abstract void handleRequest();

    public void exit() {
        PlayController.menus.pop();
    }

}
