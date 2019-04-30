package view;

import model.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.PlayController;
import model.Battle;

public class AccountMenu extends Menus{
    public static ArrayList<Account> accounts;
    Scanner scanner = new Scanner(System.in);

    public void createAccount(){
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        if (checkIfCreatedUserNameExisted(userName, accounts)) return;
        String passWord = getPassWord();
        accounts.add(new Account(userName , passWord));
    }

    private boolean checkIfCreatedUserNameExisted(String userName, ArrayList<Account> accounts) {
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(userName)) {
                System.out.println("The username has already existed.");
                return true;
            }
        }
        return false;
    }

    public void login(){
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                String passWord = scanner.nextLine();
                /*while*/ if(!passWord.equals(account.getPassWord())) {
                    System.out.println("Invalid password!");
                    return;
                }
                    //passWord = Request.getPassWordForLogin();
                //}
                Battle.setAnActiveAccount(account);
                MainMenu mainMenu = MainMenu.getInstance();
                PlayController.addMenue(mainMenu);
                return;
            }
        }
        System.out.println("Invalid Username!");
    }

    private String getPassWord() {
        Scanner scanner = new Scanner(System.in);
        Pattern characterPattern = Pattern.compile("\\w+");
        Pattern digitPattern = Pattern.compile("\\d+");

        System.out.print("Password: ");
        String passWord = scanner.nextLine();
        Matcher characterMatcher = characterPattern.matcher(passWord);
        Matcher digitMatcher = digitPattern.matcher(passWord);
        if (!characterMatcher.find() || !digitMatcher.find()){
            System.out.println("Password should have both alphabetic characters and digits!");
            passWord = scanner.nextLine();
            characterMatcher = characterPattern.matcher(passWord);
            digitMatcher = digitPattern.matcher(passWord);
        }
        return passWord;
    }

    public void showLeaderBoard(){
        accounts.sort(new AccountWinComparator());
        for (int i = 0; i < accounts.size() ; i++) {
            System.out.printf("%d - UserName : %s Wins : %d\n" , i , accounts.get(i).getUserName() , accounts.get(i).getWins());
        }
    }

    @Override
    public void help(){
        System.out.print("create account [user name]\nlogin [user name]\nshow leaderboard\n");
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Create Account")){
            createAccount();
        }
    }

    @Override
    public void open() {

    }

}

class AccountWinComparator implements Comparator<Account> {

    public int compare(Account account1, Account account2) {
        return Integer.compare(account1.getWins() , account2.getWins());
    }

}