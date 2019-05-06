package view.menus;

import controller.PlayController;
import model.Account;
import model.MenuType;
import view.Battle;
import view.Request;

public class Login extends Menu {
    private static final Login LOGIN = new Login();
    private Login() {
    }
    public static Login getInstance() {
        return LOGIN;
    }

    private Battle battle = Battle.getInstance();

    public void login () {
        System.out.println("Username: ");
        Request request = new Request(new Login());
        request.setNewCommand();
        for (Account account : AccountMenu.getInstance().accounts) {
            if (account.getUserName().equals(request.getCommand())) {
                Request request1 = new Request(new Login());
                request1.setNewCommand();
                if (!request1.getCommand().equals(account.getPassWord())) {
                    System.out.println("Invalid password!");
                    return;
                }
                if (battle.getActvieAccounts()[0] == null) {
                    battle.getActvieAccounts()[0] = account;
                } else {
                    battle.getActvieAccounts()[1] = account;
                    battle.getActvieAccounts()[0].setActiveAtTheMoment(false);
                }
                account.setActiveAtTheMoment(true);
                PlayController.menus.add(PlayingTypeMenu.getInstance());
            }
        }
        System.out.println("Invalid username!");
    }

    @Override
    public void help() {
        System.out.print("username\npassword\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.LOGIN;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Login Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
