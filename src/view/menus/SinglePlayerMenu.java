package view.menus;

import javafx.stage.Stage;

public class SinglePlayerMenu extends Menu {
    private static final SinglePlayerMenu SINGLE_PLAYER_MENU = new SinglePlayerMenu();
    private SinglePlayerMenu() {
    }
    public static SinglePlayerMenu getInstance() {
        return SINGLE_PLAYER_MENU;
    }

    @Override
    public void help(Stage primaryStage) {

    }

    @Override
    public void open(Stage primaryStage) {

    }

    @Override
    public void exit(Stage primaryStage) {

    }

}
