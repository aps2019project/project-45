package view;

import model.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountMenu {

    ArrayList<Account> accounts;

    public void createAccount(String userName , ArrayList<Account> accounts){
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(userName)) {
                System.out.println("The username has already existed.");
                return;
            }
        }

        String passWord = getPassWord();

        Account account = new Account(userName , passWord);
    }

    public void login(String userName, ArrayList<Account> accounts){
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                Scanner scanner = new Scanner(System.in);
                String passWord = scanner.nextLine();
                while (!passWord.equals(account.getPassWord())) {
                    System.out.println("Invalid password!");
                    passWord = scanner.nextLine();
                }
                
            }
        }
        System.out.println("Invalid username!");
    }

    private String getPassWord() {
        Scanner scanner = new Scanner(System.in);
        Pattern characterPattern = Pattern.compile("\\w+");
        Pattern digitPattern = Pattern.compile("\\d+");

        System.out.print("Password: ");
        String passWord = scanner.nextLine();
        Matcher characterMatcher = characterPattern.matcher(passWord);
        Matcher digitMatcher = digitPattern.matcher(passWord);
        while (!characterMatcher.find() || !digitMatcher.find()){
            System.out.println("Password should have both alphabetic characters and digits!");
            passWord = scanner.nextLine();
            characterMatcher = characterPattern.matcher(passWord);
            digitMatcher = digitPattern.matcher(passWord);
        }
        return passWord;
    }

}
