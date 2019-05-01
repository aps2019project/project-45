package controller;

import model.Square;
import view.*;
import view.menus.AccountMenu;
import view.menus.Menus;

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

            if (request.getCommand().equalsIgnoreCase("exit")){
                currentMenu.exit();
                continue;
            }

            switch (request.getRelatedMenu().TYPE){
                case "account menu":
                    accountMenuRequest(request.getCommand());
                case "main menu":
                    mainMunuRequest(request.getCommand());
                case "grave yard":
                    graveYardRequest(request.getCommand());
                case "player collection":
                    playerCollectionRequest(request.getCommand());
            }

        }
    }

    public void accountMenuRequest(String command){
        if (command.equalsIgnoreCase("create account")){
            AccountMenu.createAccount();
        } else if (command.equalsIgnoreCase("login")){
            AccountMenu.login();
        }
    }
    public void mainMunuRequest(String command){
        if (command.substring(0,5).equalsIgnoreCase("enter")) enterMenu(command);

    }
    public void graveYardRequest(String command){

    }
    public void playerCollectionRequest(String command){

    }

    public void enterMenu(String command){

    }

}

