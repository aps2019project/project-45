package view.menus;

import controller.PlayController;
import model.Account;
import model.MenuType;
import model.PlayingType;
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

    public void login() {


        do {
            System.out.println("Enter Your Username: ");
            Request requestUser = new Request();
            requestUser.setNewCommand();
            for (Account account : AccountMenu.accounts) {
                if (account.getUserName().equals(requestUser.getCommand())) {
                    System.out.println("Enter Your Password: ");
                    Request requestPass = new Request();
                    requestPass.setNewCommand();
                    if (requestPass.getCommand().equals(account.getPassWord())) {
                        PlayController.menus.add(MainMenu.getInstance());

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
        } while (true); // I think it shouldn't be "true"
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
