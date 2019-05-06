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
        boolean checkLogin=false;
        do {
            System.out.println("Enter Your Username: ");
            String userName = scanner.nextLine();
            for (Account account : CreateAccount.accounts) {  //using list of accounts
                if (account.getUserName().equals(userName)) {
                    System.out.println("Enter Your Password: ");
                    String passWord = scanner.nextLine();
                    /*while*/
                    if (passWord.equals(account.getPassWord())) {

                        checkLogin=true;
                        return;
                    }
                    //passWord = Request.getPassWordForLogin();
                    //}
                    //Battle.setAnActiveAccount(account);
                    //MainMenu mainMenu = MainMenu.getInstance();
                    //mainMenu.open();
                    /*MainMenu mainMenu = MainMenu.getInstance();
                    PlayController.addMenue(mainMenu);*/
                    return;
                }
                else {
                    System.out.println("Invalid Username or Password");
                    checkLogin=false;
                }
            }
        }while (checkLogin==false);
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.LOGIN;
    }
}
