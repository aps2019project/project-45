package view.menus;

import model.*;
import view.View;

import java.util.ArrayList;

public class Shop extends Menu {
    private static final Shop SHOP = new Shop();

    private Shop() {
    }

    public static Shop getInstance() {
        return SHOP;
    }

    private static ArrayList<CardOrItem> allAvailableCardOrItemsInShop = new ArrayList<>();
    private static ArrayList<Hero> allAvailableHeros = new ArrayList<>();
    private static ArrayList<Item> allAvailableItems = new ArrayList<>();
    private static ArrayList<Minion> allAvailableMinions = new ArrayList<>();
    private static ArrayList<Spell> allAvailableSpells = new ArrayList<>();


    public void showCollection(Account account) {
        account.getCollection().show();
    }

    public void search(String name) {
        for (CardOrItem cardOrItem : allAvailableCardOrItemsInShop) {
            if (cardOrItem.getName().equals(name)) {
                System.out.println(cardOrItem.getCardID());
                return;
            }
        }
        System.out.println("Not existing!");
    }

    public void searchCollection(String name, Account account) {
        account.getCollection().search(name);
    }

    public void buy(String name, Account account) {
        boolean available = false;
        CardOrItem availableCardOrItem = null;
        for (CardOrItem cardOrItem : allAvailableCardOrItemsInShop) {
            if (cardOrItem.getName().equals(name)) {
                availableCardOrItem = cardOrItem;
                available = true;
                break;
            }
        }
        if (!available) {
            System.out.println("Not existing in the shop!");
            return;
        }
        if (availableCardOrItem.getCost() > account.getMoney()) {
            System.out.println("inadequate money for buying this card/item!");
            return;
        }
        if (account.getCollection().getItems().size() == 3 && availableCardOrItem instanceof Item) {
            System.out.println("You can't have more than 3 items in your collection.");
            return;
        }
        if (availableCardOrItem instanceof Hero) {
            account.getCollection().getHeroes().add((Hero) availableCardOrItem);
        } else if (availableCardOrItem instanceof Item) {
            account.getCollection().getItems().add((Item) availableCardOrItem);
        } else if (availableCardOrItem instanceof Minion) {
            account.getCollection().getMinions().add((Minion) availableCardOrItem);
        } else if (availableCardOrItem instanceof Spell) {
            account.getCollection().getSpells().add((Spell) availableCardOrItem);
        }
        account.setMoney(account.getMoney() - availableCardOrItem.getCost());
    }

    public void sell(String cardID, Account account) {
        for (Hero hero : account.getCollection().getHeroes()) {
            if (hero.getCardID().equals(cardID)) {
                account.setMoney(account.getMoney() + hero.getCost());
                account.getCollection().getHeroes().remove(hero);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Item item : account.getCollection().getItems()) {
            if (item.getCardID().equals(cardID)) {
                account.setMoney(account.getMoney() + item.getCost());
                account.getCollection().getItems().remove(item);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Minion minion : account.getCollection().getMinions()) {
            if (minion.getCardID().equals(cardID)) {
                account.setMoney(account.getMoney() + minion.getCost());
                account.getCollection().getMinions().remove(minion);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Spell spell : account.getCollection().getSpells()) {
            if (spell.getCardID().equals(cardID)) {
                account.setMoney(account.getMoney() + spell.getCost());
                account.getCollection().getSpells().remove(spell);
                System.out.println("successful task :)");
                return;
            }
        }
        System.out.println("You don't have this card/item! :(");
    }

    public void show() {
        int i = 0;
        System.out.println("Heroes :");
        for (Hero hero : allAvailableHeros) {
            View.showCardOrItemInfoWithCost(hero, i);
            i++;
        }
        i = 0;
        System.out.println("Items :");
        for (Item item : allAvailableItems) {
            View.showCardOrItemInfoWithCost(item, i);
            i++;
        }
        i = 0;
        System.out.println("Cards :");
        for (Minion minion : allAvailableMinions) {
            View.showCardOrItemInfoWithCost(minion, i);
            i++;
        }
        for (Spell spell : allAvailableSpells) {
            View.showCardOrItemInfoWithCost(spell, i);
            i++;
        }
    }

    @Override
    public void help() {
        System.out.print("exit\nshow collection\nsearch [item name | card name]\nsearch collection [item name | card name]\n" +
                "buy [card name | item name]\nsell [card id | card id]\nshow\nhelp\n");
    }

    @Override
    public MenuType getType() {
        return MenuType.SHOP;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Shop " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
