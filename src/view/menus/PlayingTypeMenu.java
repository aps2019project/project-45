package view.menus;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import model.Account;
import model.MenuType;
import model.PlayingMode;
import model.PlayingType;
import view.Battle;
import view.Request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayingTypeMenu extends Menu{
    private static final PlayingTypeMenu PLAYING_MODE_MENU = new PlayingTypeMenu();
    private PlayingTypeMenu() {
    }
    public static PlayingTypeMenu getInstance() {
        return PLAYING_MODE_MENU;
    }

    public void providingForMultiPlayer() {
        Battle.getInstance().setPlayingType(PlayingType.MULTI_PLAYER);
        for (Account account : AccountMenu.getInstance().accounts) {
            System.out.println(account.getUserName());
        }
        Request request = new Request(PlayingTypeMenu.getInstance());
        request.setNewCommand();
        String userName = request.getCommand().substring(12);
        for (Account account : AccountMenu.getInstance().accounts) {
            if (account.getUserName().equals(userName)) {
                Battle.getInstance().getActvieAccounts()[1] = account;
                break;
            }
        }
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

            }

        }
    }

    @Override
    public void help() {
        System.out.print("1. Single player\n2. Multi player\n3. Help\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.PLAYING_MODE_MENU;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Playing Mode Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
