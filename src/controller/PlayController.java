package controller;

import view.Battle;
import model.Square;
import view.*;
import view.menus.*;

import java.util.ArrayList;

public class PlayController {
    public static ArrayList<Menu> menus = new ArrayList<>();

    public void firstToEnd(){
        Menu currentMenu = null;
        menus.add(AccountMenu.getInstance());

        while (true) {
            if (menus.size() == 0) break;
            if (currentMenu != menus.get(menus.size() - 1)){
                currentMenu = menus.get(menus.size() - 1);
                //if (currentMenu == null) break;
            }

            Request request = new Request(currentMenu);
            request.setNewCommand();

            if (request.getCommand().equalsIgnoreCase("exit")) {
                currentMenu.exit();
                continue;
            }
            if (request.getCommand().equalsIgnoreCase("help")) {
                request.getRelatedMenu().help();
            }

            handleRequestInRelatingMenu(currentMenu, request.getCommand());
        }
    }


    private void accountMenuRequest(String command){
        if (command.equalsIgnoreCase("create account")){

        } else if (command.equalsIgnoreCase("login")){

        }
    }
    private void createAccountMenuRequest(String command){

    }
    private void loginMenuRequest(String command){

    }
    private void playingModeMenuRequest(String command){

    }
    private void mainMenuRequest(String command){
        if (command.equalsIgnoreCase("Enter collection")) {
            menus.add(new PlayerCollection());
        } else if (command.equalsIgnoreCase("Enter shop")) {
            menus.add(Shop.getInstance());
        } else if (command.equalsIgnoreCase("Enter battle") && Battle.actvieAccounts[1] != null){ //need for attention
            //menus.add(new Battle());
            menus.add(PlayingModeMenu.getInstance());
        }
    }
    private void graveYardRequest(String command){

    }
    private void playerCollectionRequest(String command){

    }

    //almozakhrafat
    private void handleRequestInRelatingMenu(Menu currentMenu, String command) {
        switch (currentMenu.getType()) {
            case ACCOUNT_MENU:
                accountMenuRequest(command);
                break;
            case CREATE_ACCOUNT:
                createAccountMenuRequest(command);
                break;
            case LOGIN:
                loginMenuRequest(command);
                break;
            case PLAYING_MODE_MENU:
                playingModeMenuRequest(command);
                break;
            case MAIN_MENU:
                mainMenuRequest(command);
                break;
            case GRAVE_YARD:
                graveYardRequest(command);
                break;
            case PLAYER_COLLECTION:
                playerCollectionRequest(command);
                break;
        }
    }

}

