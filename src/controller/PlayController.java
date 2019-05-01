package controller;

import view.Battle;
import model.Square;
import view.*;
import view.menus.AccountMenu;
import view.menus.Menus;
import view.menus.PlayerCollection;
import view.menus.Shop;

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
            //currentMenu.open();

            Request request = new Request(currentMenu);
            request.setNewCommand();

            if (request.getCommand().equalsIgnoreCase("exit")){
                currentMenu.exit();
                continue;
            }
            if (request.getCommand().equalsIgnoreCase("help")) {
                request.getRelatedMenu().help();
            }
            switch (currentMenu.TYPE){
                case "account menu":
                    accountMenuRequest(request.getCommand());
                    break;
                case "main menu":
                    mainMenuRequest(request.getCommand());
                    break;
                case "grave yard":
                    graveYardRequest(request.getCommand());
                    break;
                case "player collection":
                    playerCollectionRequest(request.getCommand());
                    break;
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
    public void mainMenuRequest(String command){
        if (command.equalsIgnoreCase("Enter collection")) {
            PlayerCollection playerCollection = new PlayerCollection();
            playerCollection.open();
        } else if (command.equalsIgnoreCase("Enter shop")) {
            Shop shop = new Shop();
            shop.open();
        } else if (command.equalsIgnoreCase("Enter battle")){
            Battle battle = new Battle();
            battle.open();
        }
    }
    public void graveYardRequest(String command){

    }
    public void playerCollectionRequest(String command){

    }

    public void enterMenu(String command){

    }

}

