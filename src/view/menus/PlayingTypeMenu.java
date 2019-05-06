package view.menus;

import model.Account;
import model.MenuType;
import model.PlayingType;
import view.Battle;
import view.Request;

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
