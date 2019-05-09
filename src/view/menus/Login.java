package view.menus;

import controller.PlayController;
import model.Account;
import model.MenuType;
import view.Battle;
import view.Request;

public class Login extends Menu {
    private static final Login LOGIN = new Login();
    private Battle battle = Battle.getInstance();

    private Login() {
    }

    public static Login getInstance() {
        return LOGIN;
    }

    public void login() {

        Request requestUser = new Request(new Login());
        do {
            System.out.println("Enter Your Username: ");
            requestUser.setNewCommand();
            for (Account account : AccountMenu.getInstance().accounts) {
                if (account.getUserName().equals(requestUser.getCommand())) {
                    System.out.println("Enter Your Password: ");
                    Request requestPass = new Request(new Login());
                    requestPass.setNewCommand();
                    if (requestPass.getCommand().equals(account.getPassWord())) {

                        return;
                    }else {
                        System.out.println("Invalid Username or Password!");
                    }
                    if (battle.getActiveAccounts()[0] == null) {
                        battle.getActiveAccounts()[0] = account;
                    } else {
                        battle.getActiveAccounts()[1] = account;
                        battle.getActiveAccounts()[0].setActiveAtTheMoment(false);
                    }
                    account.setActiveAtTheMoment(true);
                    PlayController.menus.add(PlayingTypeMenu.getInstance());
                }else {
                    System.out.println("Invalid Username or Password!");
                }
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
