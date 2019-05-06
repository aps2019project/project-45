package view.menus;

import controller.PlayController;
import model.Account;
import model.MenuType;
import view.Request;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccount extends Menu{
    public static ArrayList<Account> accounts=new ArrayList<>(); //List of accounts
    private static final CreateAccount CREATE_ACCOUNT = new CreateAccount();
    private CreateAccount() {
    }
    public static CreateAccount getInstance() {
        return CREATE_ACCOUNT;
    }

    private AccountMenu accountMenu = AccountMenu.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount () {
        System.out.println("Username: ");
        Request request = new Request(new CreateAccount());
        request.setNewCommand();
        if (!checkIfCreatedUserNameExisted(request.getCommand(), accountMenu.accounts)) return;
        String passWord = getPassWord();
        accountMenu.accounts.add(new Account(request.getCommand() , passWord));
        PlayController.menus.add(PlayingTypeMenu.getInstance());
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
    private String getPassWord() {
        Pattern characterPattern = Pattern.compile("\\w+");
        Pattern digitPattern = Pattern.compile("\\d+");
        System.out.println("Password: ");
        Request request = new Request(new CreateAccount());
        request.setNewCommand();
        Matcher characterMatcher = characterPattern.matcher(request.getCommand());
        Matcher digitMatcher = digitPattern.matcher(request.getCommand());
        if (!characterMatcher.find() || !digitMatcher.find()) {
            System.out.println("Password should have both alphabetic characters and digits!");
            return null;
        }
        return request.getCommand();
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.CREATE_ACCOUNT;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Create Account Menu " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
