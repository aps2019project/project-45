package view.menus;

import controller.PlayController;

public abstract class Menus {
    public static String TYPE;
    public abstract void help();

    public void open(){
        PlayController.menus.push(this);
    }
    public void exit() {
        PlayController.menus.pop();
    }

}
