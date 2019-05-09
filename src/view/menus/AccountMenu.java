package view.menus;

import controller.PlayController;
import model.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.MenuType;
import view.Battle;

public class AccountMenu extends Menu {
    private static final AccountMenu ACCOUNT_MENU = new AccountMenu();
    private AccountMenu() {
    }
    public static AccountMenu getInstance() {
        return ACCOUNT_MENU;
    }

    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Account> accounts;

    public void createAccount() {
        PlayController.menus.add(CreateAccount.getInstance());
    }
    public void login() {
        PlayController.menus.add(Login.getInstance());
    }
    public void showLeaderBoard(){
        accounts.sort(new AccountWinComparator());
        for (int i = 0; i < accounts.size() ; i++) {
            System.out.printf("%d - UserName : %s Wins : %d\n" , i , accounts.get(i).getUserName() , accounts.get(i).getWins());
        }
    }

    @Override
    public void help(){
        System.out.print("create account [user name]\nlogin [user name]\nshow leaderboard\nhelp\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.ACCOUNT_MENU;
    }

    //@Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Account Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

}

class AccountWinComparator implements Comparator<Account> {

    public int compare(Account account1, Account account2) {
        return Integer.compare(account1.getWins() , account2.getWins());
    }

}