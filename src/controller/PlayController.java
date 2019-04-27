package controller;

import model.Account;
import view.Menus;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PlayController {

    private static Deque<Menus> menus = new LinkedList<>();

    private static ArrayList<Account> activeAccounts = new ArrayList<>();

    public static void setAnAccount(Account account){
        activeAccounts.add(account);
    }


    public void getRequest(){

    }
}

