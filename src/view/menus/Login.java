package view.menus;

import model.Account;
import model.MenuType;
import view.Battle;

import java.util.Scanner;

public class Login extends Menu {
    private static final Login LOGIN = new Login();
    static Scanner scanner=new Scanner(System.in); //Define Scanner
    private Login() {
    }

    public static Login getInstance() {
        return LOGIN;
    }

    public void login() {
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        for (Account account : CreateAccount.accounts) {  //using list of accounts
            if (account.getUserName().equals(userName)) {
                String passWord = scanner.nextLine();
                /*while*/
                if (!passWord.equals(account.getPassWord())) {
                    System.out.println("Invalid password!");
                    return;
                }
                //passWord = Request.getPassWordForLogin();
                //}
                Battle.setAnActiveAccount(account);
                MainMenu mainMenu = MainMenu.getInstance();
                //mainMenu.open();
                /*MainMenu mainMenu = MainMenu.getInstance();
                PlayController.addMenue(mainMenu);*/
                return;
            }
        }
        System.out.println("Invalid Username!");
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.LOGIN;
    }
}
