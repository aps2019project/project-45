package view;

import model.Account;
import model.CardOrItem;

import java.util.ArrayList;

public class PlayerCollection extends Menus {

    private ArrayList<CardOrItem> cardOrItems = new ArrayList<>();

    public void show(Account account) {
        for (int i = 0; i < account.getMainDeck().size(); i++) {
            
        }
    }

    public void search(String CardOrItemName, Account account) {
        for (int i = 0; i < cardOrItems.size(); i++) {
            if (cardOrItems.get(i).getName().equals(CardOrItemName)){
                System.out.println(i);
                return;
            }
        }
        System.out.println("The card/item isn't found!");
    }

    public void save() {

    }

    public void creatDeck() {

    }

    public void add() {

    }

    public void remove() {

    }

    public void validate() {

    }

    public void selectDeck() {

    }

    public void showAllDecks() {

    }

    public void showDeck() {

    }
    
    public void help() {

    }
}
