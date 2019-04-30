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
        Menus currentMenu = null;
        menus.push(new AccountMenu());
        while (true) {
            if (currentMenu != menus.peek()){
                currentMenu = menus.peek();
            }
            if (currentMenu == null) break;
            currentMenu.open();

            Request request = new Request(menus.peek());
            request.setNewCommand();
            request.getRelatedMenu().handleRequest(request.getCommand());
        }
    }

    public static void addMenue (Menus menu){
        menus.push(menu);
    }
}

