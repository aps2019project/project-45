package view.menus;

import model.Account;
import model.MenuType;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

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

    /*public void createAccount(){
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        if (checkIfCreatedUserNameExisted(userName, accountMenu.accounts)) return;
        String passWord = getPassWord();
        accountMenu.accounts.add(new Account(userName , passWord));
        MainMenu mainMenu = MainMenu.getInstance();
    }*/

    private static boolean checkIfCreatedUserNameExisted(String userName, ArrayList<Account> accounts) {
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(userName)) {
                System.out.println("The username has already existed.");
                return true;
            }
        }
        return false;
    }


    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.CREATE_ACCOUNT;
    }
}
