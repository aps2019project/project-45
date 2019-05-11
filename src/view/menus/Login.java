package view.menus;

import controller.PlayController;
import model.Account;
import model.MenuType;
import model.PlayingType;
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

    private String secondUserName;

    public void login() {
        boolean inLogin = true;
        do {
            Request requestUser = new Request(Login.getInstance());
            if (secondUserName != null) {
                System.out.printf("second username : %s\n", secondUserName);
            } else {
                System.out.println("Enter Your Username: ");
                requestUser.setNewCommand();
                if (!requestUser.exitOrHelp(Login.getInstance(), requestUser.getCommand())) return;
            }

            for (Account account : AccountMenu.accounts) {
                if (account.getUserName().equals(requestUser.getCommand())) {
                    System.out.println("Enter Your Password: ");
                    Request requestPass = new Request(Login.getInstance());
                    requestPass.setNewCommand();
                    if (!requestPass.exitOrHelp(Login.getInstance(), requestPass.getCommand())) return;

                    if (requestPass.getCommand().equals(account.getPassWord())) {
                        if (battle.getActiveAccounts()[0] == null) {
                            battle.getActiveAccounts()[0] = account;
                        } else {
                            battle.getActiveAccounts()[1] = account;
                            battle.getActiveAccounts()[0].setActiveAtTheMoment(false);
                        }
                        account.setActiveAtTheMoment(true);
                        PlayController.menus.add(MainMenu.getInstance());
                        inLogin = false;
                    } else {
                        if (secondUserName != null) System.out.println("Invalid password!");
                        else System.out.println("Invalid Username or Password!");
                    }
                }
            }

        } while (inLogin);
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

    public void setSecondUserName(String secondUserName) {
        this.secondUserName = secondUserName;
    }
}