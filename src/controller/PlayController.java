package controller;

import model.Account;
import view.AccountMenu;
import view.MainMenu;
import view.Menus;
import view.Request;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PlayController {

    private static Deque<Menus> menus = new LinkedList<>();
    private static ArrayList<Account> activeAccounts = new ArrayList<>();

    public static void setAnActiveAccount(Account account){
        activeAccounts.add(account);
    }

    public void firstToEnd(){
        AccountMenu accountMenu = new AccountMenu();
        Request request = new Request();

    }


    public void getRequest(){

    }
}

