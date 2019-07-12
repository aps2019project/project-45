package view.menus;

import javafx.stage.Stage;
import model.*;

import java.util.HashMap;
import java.util.Map;

public class PlayerCollection extends Menu {
    private static HashMap<String, Map<String, Card>> decks = new HashMap<>();

    //private String selectedDeckName;
    private Map<String, Card> heroes = new HashMap<>();
    private Map<String, Card> minions = new HashMap<>();
    private Map<String, Card> spells = new HashMap<>();
    private Map<String, Card> items = new HashMap<>();

    private Account player;

    @Override
    public void open(Stage primaryStage) {

    }

    @Override
    public void help(Stage primaryStage) {

    }





    public void show() {
        /*System.out.println("Heroes :");
        for (int i = 0; i < heroes.size(); i++) {
            View.showcardInfoWithCost(heroes.get(i), i);
        }
        System.out.println("Items :");
        for (int i = 0; i < items.size(); i++) {
            View.showcardInfoWithCost(items.get(i), i);
        }
        System.out.println("Cards :");
        for (int i = 0; i < minions.size(); i++) {
            View.showcardInfoWithCost(minions.get(i), i);
        }
        for (int i = 0; i < spells.size(); i++) {
            View.showcardInfoWithCost(spells.get(i), i);
        }*/
    }

    public void search(String name) {
        boolean found = false;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getName().equals(name)) {
                System.out.printf("The card is existed in the collection with number : %d\n", i + 1);
                found = true;
            }
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                System.out.printf("The item is existed in the collection with number : %d\n", i + 1);
                found = true;
            }
        }
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getName().equals(name)) {
                System.out.printf("The card is existed in the collection with number : %d\n", i + 1);
                found = true;
            }
        }
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getName().equals(name)) {
                System.out.printf("The card is existed in the collection with number : %d\n", i + 1);
                found = true;
            }
        }
        if (found) return;
        System.out.println("The card or item isn't existed in the collection!");
    }

    public void createDeck(String name) {
        for (String deckName : decks.keySet()) {
            if (deckName.equals(name)) {
                System.out.println("A deck with this name has already existed! Please set another name.");
                return;
            }
        }
        Map<String, Card> deck = new HashMap<>();
        decks.put(name, deck);
    }

    public void deleteDeck(String name) {
        for (String deckName : decks.keySet()) {
            if (deckName.equals(name)) {
                decks.remove(deckName);
                return;
            }
        }
        System.out.println("Invalid deck name!");
    }

    public void add(String cardID, String deckName) {
        if (heroes.get(cardID) == null && minions.get(cardID) == null && spells.get(cardID) == null && items.get(cardID)
        == null) {
            System.out.println("The card/item doesn't exist in the collection!");
            return;
        }
        if (decks.get(deckName).get(cardID) != null) {
            System.out.println("Sorry! The deck already has the card/item!");
            return;
        }
        int nonItemCardsNum = 0;
        for (Card card : decks.get(deckName).values()) {
            if (!(card instanceof Item)) {
                nonItemCardsNum++;
                if (nonItemCardsNum == 20) {
                    System.out.println("Your deck is full enough for adding another card.");
                    return;
                }
            }
        }
        if (heroes.size() != 0 && Shop.cards.get(cardID) instanceof Hero) {
            System.out.println("You had already a hero in your deck.");
        }
    }

    public void remove(String cardID, String deckName) {
        if (decks.get(deckName).containsKey(cardID)) {
            decks.get(deckName).remove(cardID);
            return;
        }
        System.out.println("The card/item doesn't exist in the deck!");
    }

    /*public static boolean validateDeck(String deckName) {
        if (decks.get(deckName).size() == 0) return false;
        int heroNum = 0;
        int cardNum = 0;
        int itemNum = 0;
        for (Card card : decks.get(deckName)) {
            if (card instanceof Hero) heroNum++;
            if (card instanceof Item) itemNum++;
            if (card instanceof Minion || card instanceof Spell) cardNum++;
        }
        if (heroNum != 1) return false;
        if (itemNum > 1) return false;
        if (cardNum != 20) return false;
        return true;
    }*/

    /*public void selectDeck(String deckName) {
        if (!validateDeck(deckName)) {
            System.out.println("Invalid deck!");
            return;
        }

        Collections.shuffle(decks.get(deckName));
        for (int i = 0; i < decks.get(deckName).size(); i++) {
            if (decks.get(deckName).get(decks.get(deckName).size() - 1) instanceof Hero &&
                    decks.get(deckName).get(decks.get(deckName).size() - 2) instanceof Item) {
                break;
            }
            if (decks.get(deckName).get(i) instanceof Hero){
                Collections.swap(decks.get(deckName) , i , decks.get(deckName).size() - 1);
                i--;
                continue;
            }
            if (decks.get(deckName).get(i) instanceof Item) {
                Collections.swap(decks.get(deckName) , i , decks.get(deckName).size() - 2);
                i--;
                continue;
            }
        }
        selectedDeckName = deckName;
    }*/

    /*public void showDeck(String deckName) {
        int num = 0;
        System.out.println("Heroes :");
        for (Card card : decks.get(deckName)) {
            if (card instanceof Hero) {
                View.showcardInfoWithCost(card, num);
                num++;
            }
        }
        num = 0;
        System.out.println("Items :");
        for (Card card : decks.get(deckName)) {
            if (card instanceof Item) {
                View.showcardInfoWithCost(card, num);
                num++;
            }
        }
        num = 0;
        System.out.println("Cards :");
        for (Card card : decks.get(deckName)) {
            if (card instanceof Minion) {
                View.showcardInfoWithCost(card, num);
                num++;
            } else if (card instanceof Spell) {
                View.showcardInfoWithCost(card, num);
                num++;
            }
        }
    }*/

    /*public void showAllDecks() {
        if (selectedDeckName != null) {
            System.out.printf("1 : %s (selected deck) :\n", selectedDeckName);
            showDeck(selectedDeckName);
            for (String deckName : decks.keySet()) {
                if (deckName.equals(selectedDeckName)) continue;
                showDeck(deckName);
            }
            return;
        }
        for (String deckName : decks.keySet()) {
            showDeck(deckName);
        }
    }*/



    public Account getPlayer() {
        return player;
    }

    public void setPlayer(Account player) {
        this.player = player;
    }

    public Map<String, Card> getHeroes() {
        return heroes;
    }

    public void setHeroes(Map<String, Card> heroes) {
        this.heroes = heroes;
    }

    public Map<String, Card> getMinions() {
        return minions;
    }

    public void setMinions(Map<String, Card> minions) {
        this.minions = minions;
    }

    public Map<String, Card> getSpells() {
        return spells;
    }

    public void setSpells(Map<String, Card> spells) {
        this.spells = spells;
    }

    public Map<String, Card> getItems() {
        return items;
    }

    public void setItems(Map<String, Card> items) {
        this.items = items;
    }

}
