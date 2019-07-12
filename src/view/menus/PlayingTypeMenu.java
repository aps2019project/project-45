package view.menus;

import controller.PlayController;
import javafx.stage.Stage;
import model.Account;
import model.PlayingMode;
import model.PlayingType;
import view.Battle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayingTypeMenu extends Menu {
    private static final PlayingTypeMenu PLAYING_MODE_MENU = new PlayingTypeMenu();
    private PlayingTypeMenu() {
    }
    public static PlayingTypeMenu getInstance() {
        return PLAYING_MODE_MENU;
    }

    private Battle battle = Battle.getInstance();

    public void openSiglePlayerMenu(){
        PlayController.menus.add(SinglePlayerMenu.getInstance());
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
