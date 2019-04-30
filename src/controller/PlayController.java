package controller;

import model.Account;
import model.Square;
import view.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PlayController {

    public static Deque<Menus> menus = new LinkedList<>();
    private static Square[][] square = new Square[5][9];


    public void firstToEnd(){
        AccountMenu accountMenu = new AccountMenu();
        menus.push(accountMenu);
        Request request = new Request(accountMenu);

    }

    public static void addMenue (Menus menu){
        menus.push(menu);
    }
}

