package view.menus;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import controller.PlayController;
import model.Account;
import model.MenuType;
import model.PlayingMode;
import model.PlayingType;
import view.Battle;
import view.Request;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayingTypeMenu extends Menu{
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
    public void providingForMultiPlayer() {
        battle.setPlayingType(PlayingType.MULTI_PLAYER);
        for (Account account : AccountMenu.accounts) {
            System.out.println(account.getUserName());
        }
        boolean badRequest = false;
        label:
        while (!badRequest) {
            Request request = new Request(PlayingTypeMenu.getInstance());
            request.setNewCommand();
            if (request.getCommand().equals("exit")) {
                exit();
                return;
            }
            String userName = request.getCommand().substring(12); // ask please   Select user [user name]
            for (Account account : AccountMenu.accounts) {
                if (account.getUserName().equals(userName)) {
                    System.out.println("Password :");
                    Request request1 = new Request(PlayingTypeMenu.getInstance());
                    request1.setNewCommand();
                    if (!request1.getCommand().equals(battle.getActiveAccounts()[1].getPassWord())) {
                        System.out.println("incorrect password :(\nTry again or exit!");
                        continue label;
                    } else {
                        battle.getActiveAccounts()[1] = account;
                        badRequest = true;
                        PlayController.menus.add(MainMenu.getInstance()); //need to debug whole of the project approximately
                        break ;
                    }
                }
            }
        }
    }
    public void modeForMultiPlayer() {
        System.out.println("Set the mode of play:");
        System.out.println(PlayingMode.FIRST + " : " + PlayingMode.FIRST.getMessage());
        System.out.println(PlayingMode.SECOND + " : " + PlayingMode.SECOND.getMessage());
        System.out.println(PlayingMode.THIRD + " : " + PlayingMode.THIRD.getMessage());
        Request request1 = new Request(PlayingTypeMenu.getInstance());
        request1.setNewCommand();
        Pattern modePattern = Pattern.compile("Start multiplayer game (FIRST|SECOND|THIRD) *(\\d)*");
        Matcher modeMatcher = modePattern.matcher(request1.getCommand());
        if (modeMatcher.matches()) {
            if (modeMatcher.group(1).equalsIgnoreCase(PlayingMode.FIRST.toString())){
                battle.setPlayingMode(PlayingMode.FIRST);
            } else if (modeMatcher.group(1).equalsIgnoreCase(PlayingMode.SECOND.toString())){
                battle.setPlayingMode(PlayingMode.SECOND);
            } else if (modeMatcher.group(1).equalsIgnoreCase(PlayingMode.THIRD.toString())){
                battle.setPlayingMode(PlayingMode.THIRD);
            }
            //maybe need to complete
        }
    }

    public boolean checkSecondPlayerDeckValidation() {
        if (!PlayerCollection.validateDeck(battle.getActiveAccount().getSelectedDeckName())) {
            System.out.println("selected deck for second player is invalid");
            return false;
        }
        return true;
    }

    @Override
    public void help() {
        System.out.print("1. Single player\n2. Multi player\n3. Help\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.PLAYING_TYPE_MENU;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Playing Mode Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
