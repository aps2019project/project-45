package view.menus;

import model.Account;
import model.CardOrItem;
import view.menus.Menus;

import java.util.ArrayList;

public class PlayerCollection extends Menus {
    static final String TYPE = "player collection";

    private ArrayList<CardOrItem> cardOrItems = new ArrayList<>();

    public void show(Account account) {
        for (int i = 0; i < account.getMainDeck().size(); i++) {
            
        }
    }

    public void search(String CardOrItemName, Account account) {
        for (int i = 0; i < cardOrItems.size(); i++) {
            if (cardOrItems.get(i).getName().equalsIgnoreCase(CardOrItemName)){
                System.out.println(i);
                return;
            }
        }
        System.out.println("The card/item isn't found!");
    }

    @Override
    public void help() {

    }
}