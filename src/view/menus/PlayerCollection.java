package view.menus;

import model.*;
import view.View;
import view.menus.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PlayerCollection extends Menu {
    private static final int VALID_DECK_SIZE = 20 + 1;
    private HashMap<String, ArrayList<CardOrItem>> decks = new HashMap<>();
    private String selectedDeckName;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();

    public void show() {
        System.out.println("Heroes :");
        for (int i = 0; i < heroes.size(); i++) {
            View.showCardOrItemInformationWithCost(heroes.get(i), i);
        }
        System.out.println("Items :");
        for (int i = 0; i < items.size(); i++) {
            View.showCardOrItemInformationWithCost(items.get(i), i);
        }
        System.out.println("Cards :");
        for (int i = 0; i < minions.size(); i++) {
            View.showCardOrItemInformationWithCost(minions.get(i), i);
        }
        for (int i = 0; i < spells.size(); i++) {
            View.showCardOrItemInformationWithCost(spells.get(i), i);
        }
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
        ArrayList<CardOrItem> deck = new ArrayList<>();
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
        if (decks.get(deckName).size() == VALID_DECK_SIZE) {
            System.out.println("Your deck is full! You cannot add any more card or item to it.");
            return;
        }
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem.getCardID().equals(cardID)) {
                System.out.println("Sorry! The deck already has the card/item!");
                return;
            }
        }
        for (Hero hero : heroes) {
            if (hero.getCardID().equals(cardID)) {
                for (CardOrItem cardOrItem : decks.get(deckName)) {
                    if (cardOrItem instanceof Hero) {
                        System.out.println("Sorry! You had already a hero in your deck.");
                        return;
                    }
                }
                decks.get(deckName).add(hero);
                return;
            }
        }
        for (Item item : items) {
            if (item.getCardID().equals(cardID)) {
                decks.get(deckName).add(item);
                return;
            }
        }
        for (Minion minion : minions) {
            if (minion.getCardID().equals(cardID)) {
                decks.get(deckName).add(minion);
                return;
            }
        }
        for (Spell spell : spells) {
            if (spell.getCardID().equals(cardID)) {
                decks.get(deckName).add(spell);
                return;
            }
        }
        System.out.println("Sorry! The card/item isn't in the collection.");
    }

    public void remove(String cardID, String deckName) {
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem.getCardID().equals(cardID)) {
                decks.get(deckName).remove(cardOrItem);
                return;
            }
        }
        System.out.println("The card/item doesn't exist in the deck!");
    }

    public boolean validateDeck(String deckName) {
        int heroNum = 0;
        int cardNum = 0;
        if (decks.get(deckName).size() != VALID_DECK_SIZE) {
            return false;
        }
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem instanceof Hero) {
                heroNum++;
                if (heroNum > 1) return false;
            }
            if (cardOrItem instanceof Minion || cardOrItem instanceof Spell) {
                cardNum++;
            }
        }
        if (heroNum == 0) return false;
        if (cardNum != 20) return false;
        return true;
    }

    public void selectDeck(String deckName) {
        if (!validateDeck(deckName)) {
            System.out.println("Invalid deck!");
            return;
        }
        selectedDeckName = deckName;
    }

    public void showDeck(String deckName) {
        int num = 0;
        System.out.println("Heroes :");
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem instanceof Hero) {
                View.showCardOrItemInformationWithCost(cardOrItem, num);
                num++;
            }
        }
        num = 0;
        System.out.println("Items :");
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem instanceof Item) {
                View.showCardOrItemInformationWithCost(cardOrItem, num);
                num++;
            }
        }
        num = 0;
        System.out.println("Cards :");
        for (CardOrItem cardOrItem : decks.get(deckName)) {
            if (cardOrItem instanceof Minion) {
                View.showCardOrItemInformationWithCost(cardOrItem, num);
                num++;
            } else if (cardOrItem instanceof Spell) {
                View.showCardOrItemInformationWithCost(cardOrItem, num);
                num++;
            }
        }
    }

    public void showAllDecks() {
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
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    MAli Seif
    Kashani,[05.05.19 19:51]

    @Override
    public void help() {
        System.out.print("exit\nshow\nsearch [card name | item name]\nsave\ncreate deck[deck name]\ndelete deck[deck name]\n" +
                "add [card id | card id | hero id] to deck [deck name]\nremove [card id | card id | hero id]from deck [deck name]" +
                "\nvalidate deck[deck name]\nselect deck[deck name]\nshow all decks\nshow deck[deck name]\nhelp");
    }

    @Override
    public MenuType getType() {
        return MenuType.PLAYER_COLLECTION;
    }

}