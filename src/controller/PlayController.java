package controller;

import view.Battle;
import view.*;
import view.menus.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayController {
    public static ArrayList<Menu> menus = new ArrayList<>();
    private Battle battle = Battle.getInstance();

    public void firstToEnd(){
        Menu currentMenu = null;
        menus.add(AccountMenu.getInstance());

        while (true) {
            if (menus.size() == 0) break;
            if (currentMenu != menus.get(menus.size() - 1)){
                currentMenu = menus.get(menus.size() - 1);
                currentMenu.open();
                //if (currentMenu == null) break;
            }

            Request request = new Request(currentMenu);
            request.setNewCommand();

            handleRequestInRelatingMenu(currentMenu, request.getCommand());
        }
    }


    private void accountMenuRequest(String command){
        if (command.equalsIgnoreCase("create account")){
            AccountMenu.getInstance().createAccount();
        } else if (command.equalsIgnoreCase("login")){
            AccountMenu.getInstance().login();
        } else if (command.equalsIgnoreCase("show leaderboard")) {
            AccountMenu.getInstance().showLeaderBoard();
        }
    }
    private void createAccountMenuRequest(String command){
        CreateAccount.getInstance().createAccount();
    }
    private void loginMenuRequest(String command){
        Login.getInstance().login();
    }
    private void playingTypeMenuRequest(String command){
        if (command.equalsIgnoreCase("Single player")){
            PlayingTypeMenu.getInstance().openSiglePlayerMenu();
        } else if (command.equalsIgnoreCase("Multi player")){
            PlayingTypeMenu.getInstance().providingForMultiPlayer();
        }
    }
    private void mainMenuRequest(String command){
        if (command.equalsIgnoreCase("Enter collection")) {
            menus.add(new PlayerCollection());
        } else if (command.equalsIgnoreCase("Enter shop")) {
            menus.add(Shop.getInstance());
        } else if (command.equalsIgnoreCase("Enter battle") && battle.getActvieAccounts()[1] != null){ //need for attention
            menus.add(PlayingTypeMenu.getInstance());
        }
    }
    private void graveYardRequest(String command){

    }
    private void playerCollectionRequest(String command){
        Pattern showPattern = Pattern.compile("show");
        Matcher showMatcher = showPattern.matcher(command);
        if (showMatcher.matches()) {
            getRelatingCollection().show();
            return;
        }
        Pattern searchPattern = Pattern.compile("search (\\w+)");
        Matcher searchMatcher = searchPattern.matcher(command);
        if (searchMatcher.matches()) {
            getRelatingCollection().search(searchMatcher.group(1));
            return;
        }
        Pattern createdeckPattern = Pattern.compile("create deck (\\w+)");
        Matcher createdeckMatcher = createdeckPattern.matcher(command);
        if (createdeckMatcher.matches()) {
            getRelatingCollection().createDeck(createdeckMatcher.group(1));
            return;
        }
        Pattern deleteDeckPattern = Pattern.compile("delete deck (\\w+)");
        Matcher deleteDeckMatcher = deleteDeckPattern.matcher(command);
        if (deleteDeckMatcher.matches()) {
            getRelatingCollection().deleteDeck(deleteDeckMatcher.group(1));
            return;
        }
        Pattern addPattern = Pattern.compile("add (\\w+) to deck (\\w+)");
        Matcher addMatcher = addPattern.matcher(command);
        if (addMatcher.matches()) {
            getRelatingCollection().add(addMatcher.group(1) , addMatcher.group(2));
            return;
        }
        Pattern removePattern = Pattern.compile("remoeve (\\w+) from deck (\\w+)");
        Matcher removeMatcher = removePattern.matcher(command);
        if (removeMatcher.matches()) {
            getRelatingCollection().remove(removeMatcher.group(1) , removeMatcher.group(2));
            return;
        }
        Pattern validatePattern = Pattern.compile("validate deck (\\w+)");
        Matcher validateMatcher = validatePattern.matcher(command);
        if (validateMatcher.matches()) {
            getRelatingCollection().validateDeck(validateMatcher.group(1));
            return;
        }
        Pattern selectDeckPattern = Pattern.compile("select deck (\\w+)");
        Matcher selectDeckMatcher = selectDeckPattern.matcher(command);
        if (searchMatcher.matches()) {
            getRelatingCollection().selectDeck(selectDeckMatcher.group(1));
            return;
        }
        Pattern showAllDecksPattern = Pattern.compile("show all decks");
        Matcher showAllDecksMatcher = showAllDecksPattern.matcher(command);
        if (showAllDecksMatcher.matches()) {
            getRelatingCollection().showAllDecks();
            return;
        }
        Pattern showDeckPattern = Pattern.compile("show deck (\\w+)");
        Matcher showDeckMatcher = showDeckPattern.matcher(command);
        if (showDeckMatcher.matches()) {
            getRelatingCollection().showDeck(showDeckMatcher.group(1));
        }
    } // need to be completed

    //almozakhrafat
    private void handleRequestInRelatingMenu(Menu currentMenu, String command) {
        checkForHelpOrExit(command);
        switch (currentMenu.getType()) {
            case ACCOUNT_MENU:
                accountMenuRequest(command);
                break;
            /*case CREATE_ACCOUNT:
                createAccountMenuRequest(command);
                break;
            case LOGIN:
                loginMenuRequest(command);
                break;*/
            case PLAYING_MODE_MENU:
                playingTypeMenuRequest(command);
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

    private void checkForHelpOrExit(String command) {
        if (command.equalsIgnoreCase("help") || command.equalsIgnoreCase("Show munu")) {
            menus.get(menus.size() - 1).help();
        } else if (command.equalsIgnoreCase("exit")) {
            menus.get(menus.size() - 1).exit();
        }
    }
    private PlayerCollection getRelatingCollection () {
        if (battle.getActvieAccounts()[0].isActiveAtTheMoment()) return battle.getActvieAccounts()[0].getCollection();
        else return battle.getActvieAccounts()[1].getCollection();
    }


}

