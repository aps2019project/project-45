package controller;

import view.Battle;
import view.menus.*;

import java.util.ArrayList;

public class PlayController{
    public static ArrayList<Menu> menus = new ArrayList<>();
    private Battle battle = Battle.getInstance();
    private Shop shop = Shop.getInstance();

    /*public void firstToEnd(String[] args) {
        Menu currentMenu = null;
        menus.add(AccountMenu.getInstance());

        while (menus.size() != 0) {
            if (currentMenu != menus.get(menus.size() - 1)) {
                currentMenu = menus.get(menus.size() - 1);
                currentMenu.open();
            }

            Request request = new Request(currentMenu);
            request.setNewCommand();

            handleRequestInRelatingMenu(Objects.requireNonNull(currentMenu), request.getCommand());
        }
    }*/


    private void singlePlayerMenuRequest(String command) {
        if (command.equalsIgnoreCase("Story")) {

        } else if (command.equalsIgnoreCase("Custom game")) {

        }
    } //later

    /*private void mainMenuRequest(String command) {
        if (command.equalsIgnoreCase("Enter collection")) {
            MainMenu.getInstance().enterCollection();
        } else if (command.equalsIgnoreCase("Enter shop")) {
            MainMenu.getInstance().enterShop();
        } else if (command.equalsIgnoreCase("Enter battle")) { //attention
            if (battle.getBattlePlayers()[1] != null) {
                if (PlayingTypeMenu.getInstance().checkSecondPlayerDeckValidation()) {
                    PlayingTypeMenu.getInstance().modeForMultiPlayer();
                    menus.add(battle);
                    return;
                } else {
                    return;
                }
            }
            if (!PlayerCollection.validateDeck(battle.getActiveAccount().getDeckName())) {
                System.out.println("your selected deck is invalid!");
                return;
            }
            MainMenu.getInstance().enterPlayingTypeMenu();
        }
    }*/

    /*private void playerCollectionRequest(String command) {
        Pattern showPattern = Pattern.compile("show");
        Matcher showMatcher = showPattern.matcher(command);
        if (showMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().show();
            return;
        }
        Pattern searchPattern = Pattern.compile("search (\\w+)");
        Matcher searchMatcher = searchPattern.matcher(command);
        if (searchMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().search(searchMatcher.group(1));
            return;
        }
        Pattern createdeckPattern = Pattern.compile("create deck (\\w+)");
        Matcher createdeckMatcher = createdeckPattern.matcher(command);
        if (createdeckMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().createDeck(createdeckMatcher.group(1));
            return;
        }
        Pattern deleteDeckPattern = Pattern.compile("delete deck (\\w+)");
        Matcher deleteDeckMatcher = deleteDeckPattern.matcher(command);
        if (deleteDeckMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().deleteDeck(deleteDeckMatcher.group(1));
            return;
        }
        Pattern addPattern = Pattern.compile("add (\\w+) to deck (\\w+)");
        Matcher addMatcher = addPattern.matcher(command);
        if (addMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().add(addMatcher.group(1), addMatcher.group(2));
            return;
        }
        Pattern removePattern = Pattern.compile("remoeve (\\w+) from deck (\\w+)");
        Matcher removeMatcher = removePattern.matcher(command);
        if (removeMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().remove(removeMatcher.group(1), removeMatcher.group(2));
            return;
        }
        Pattern validatePattern = Pattern.compile("validate deck (\\w+)");
        Matcher validateMatcher = validatePattern.matcher(command);
        if (validateMatcher.matches()) {
            PlayerCollection.validateDeck(validateMatcher.group(1));
            return;
        }
        Pattern selectDeckPattern = Pattern.compile("select deck (\\w+)");
        Matcher selectDeckMatcher = selectDeckPattern.matcher(command);
        if (searchMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().selectDeck(selectDeckMatcher.group(1));
            return;
        }
        Pattern showAllDecksPattern = Pattern.compile("show all decks");
        Matcher showAllDecksMatcher = showAllDecksPattern.matcher(command);
        if (showAllDecksMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().showAllDecks();
            return;
        }
        Pattern showDeckPattern = Pattern.compile("show deck (\\w+)");
        Matcher showDeckMatcher = showDeckPattern.matcher(command);
        if (showDeckMatcher.matches()) {
            battle.getActiveAccount().getPlayerCollection().showDeck(showDeckMatcher.group(1));
        } //new comment manlssdfsdfsd change
    } // need to be completed
*/
    /*private void shopRequest(String command) {
        Pattern showCollectionPattern = Pattern.compile("show collection");
        Matcher showCollectionMatcher = showCollectionPattern.matcher(command);
        if (showCollectionMatcher.matches()) {
            shop.showCollection();
            return;
        }
        Pattern searchPattern = Pattern.compile("search (\\w+)");
        Matcher searchMatcher = searchPattern.matcher(command);
        if (searchMatcher.matches()) {
            shop.search(searchMatcher.group(1));
            return;
        }
        Pattern searchCollectionPattern = Pattern.compile("search collection (\\w+)");
        Matcher searchCollectionMatcher = searchCollectionPattern.matcher(command);
        if (searchCollectionMatcher.matches()) {
            shop.searchCollection(searchCollectionMatcher.group(1));
            return;
        }
        Pattern buyPattern = Pattern.compile("buy (\\w+)");
        Matcher buyMatcher = buyPattern.matcher(command);
        if (buyMatcher.matches()) {
            shop.buy(buyMatcher.group(1));
            return;
        }
        Pattern sellPattern = Pattern.compile("sell (\\w+)");
        Matcher sellMatcher = sellPattern.matcher(command);
        if (sellMatcher.matches()) {
            shop.sell(sellMatcher.group(1));
            return;
        }
        Pattern showPattern = Pattern.compile("show");
        Matcher showMatcher = showPattern.matcher(command);
        if (showMatcher.matches()) {
            shop.show();
            return;
        }
    }*/

    private void battleRequest(String command) {

    } //later

    private void graveYardRequest(String command) {

    } //later

    private void checkForHelpOrExit(String command) {
        if (command.equalsIgnoreCase("help") || command.equalsIgnoreCase("Show munu")) {
            //menus.get(menus.size() - 1).help();
        } else if (command.equalsIgnoreCase("exit")) {
            //menus.get(menus.size() - 1).exit();
        }
    }

    /*private PlayerCollection battle.getActiveAccount().getPlayerCollection() {
        if (battle.getActiveAccount()s()[0].isActiveAtTheMoment()) return battle.getActiveAccount()s()[0].getPlayerCollection();
        else return battle.getActiveAccount()s()[1].getPlayerCollection();
    }*/

}

