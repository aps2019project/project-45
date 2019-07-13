package view.menus;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.*;
import view.Battle;
import javafx.scene.image.Image;
import view.menus.PlayMenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shop extends PlayMenu {
    private static final Shop SHOP = new Shop();

    private Shop() {
    }

    public static Shop getInstance() {
        return SHOP;
    }




    private Battle battle = Battle.getInstance();

    /*private static ArrayList<Card> allAvailablecardsInShop = new ArrayList<>();
    private static ArrayList<Hero> allAvailableHeros = new ArrayList<>();
    private static ArrayList<Item> allAvailableItems = new ArrayList<>();
    private static ArrayList<Minion> allAvailableMinions = new ArrayList<>();
    private static ArrayList<Spell> allAvailableSpells = new ArrayList<>();
*/
    public static Map<String, Card> cards = new HashMap<>();
    public static Map<String, Card> heroes = new HashMap<>();
    public static Map<String, Card> minions = new HashMap<>();
    public static Map<String, Card> spells = new HashMap<>();
    public static Map<String, Card> items = new HashMap<>();



    @Override
    public void open(Stage primaryStage) {
        //Group root = (Group) primaryStage.getScene().getRoot();

        Group root = (Group) primaryStage.getScene().getRoot();
        primaryStage.getScene().getRoot().setStyle("-fx-font-size: 15");

        Image image = null;
        Image[] images = new Image[10];
        try {
            image = new Image(new FileInputStream("neutral_prismatic_unit@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView[] imageViews = new ImageView[10];
        for (int i = 0; i < 10; i++) {
            imageViews[i] = new ImageView(image);
            imageViews[i].setFitWidth(200);
            imageViews[i].setFitHeight(250);
            if (i < 5) {
                imageViews[i].setLayoutX(250 * i + 100);
                imageViews[i].setLayoutY(80);
            }
            else {
                imageViews[i].setLayoutX(imageViews[i - 5].getLayoutX());
                imageViews[i].setLayoutY(380);
            }
        }

        Label[] first = new Label[10];
        Label[] second = new Label[10];
        for (int i = 0; i < 10; i++) {
            first[i] = new Label();
            second[i] = new Label();
            if (i < 5) {
                first[i].setLayoutX(i * 250 + 135);
                first[i].setLayoutY(219);
                second[i].setLayoutX(i * 250 + 242);
                second[i].setLayoutY(219);
            } else {
                first[i].setLayoutX(first[i - 5].getLayoutX());
                first[i].setLayoutY(519);
                second[i].setLayoutX(second[i - 5].getLayoutX());
                second[i].setLayoutY(519);
            }
        }



        MenuBar menubar = new MenuBar();
        menubar.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());
        Menu heroMenu = new Menu("Hero");
        Menu minionMenu = new Menu("Minion");
        Menu spellMenu = new Menu("Spell");
        Menu itemMenu = new Menu("Item");
        Menu changeMenutToRight = new Menu(">>");
        Menu changeMenuToLeft = new Menu("<<");
        menubar.getMenus().addAll(heroMenu, minionMenu, spellMenu, itemMenu, changeMenuToLeft, changeMenutToRight);

        root.getChildren().add(menubar);
        root.getChildren().addAll(imageViews);

        primaryStage.show();

        heroMenu.setOnShowing(event -> {


        });
    }




    public void showCollection() {
        battle.getActiveAccount().getPlayerCollection().show();
    }

   /* public String  search(String name) {
        for (Card card : cards.values()) {
            if (card.getName().equals(name)) {
                System.out.println("existing");
                return card.getCardID();
            }
        }
        System.out.println("Not existing!");
        return null;
    }*/

    public ArrayList<String> searchCollection(String name) {
        ArrayList<String> result = new ArrayList<>();
        PlayerCollection playerCollection = battle.getActiveAccount().getPlayerCollection();
        for (Card card : playerCollection.getHeroes().values()) {
            if (card.getName().equals(name)) result.add(card.getCardID());
        }
        for (Card card : playerCollection.getMinions().values()) {
            if (card.getName().equals(name)) result.add(card.getCardID());
        }
        for (Card card : playerCollection.getSpells().values()) {
            if (card.getName().equals(name)) result.add(card.getCardID());
        }
        for (Card card : playerCollection.getItems().values()) {
            if (card.getName().equals(name)) result.add(card.getCardID());
        }
        return result;
    }

    /*public void buy(String name) {
        boolean available = false;
        Card availablecard = null;
        for (Card card : allAvailablecardsInShop) {
            if (card.getName().equals(name)) {
                availablecard = card;
                available = true;
                break;
            }
        }
        if (!available) {
            System.out.println("Not existing in the shop!");
            return;
        }
        if (availablecard.getCost() > battle.getActiveAccount().getMoney()) {
            System.out.println("inadequate money for buying this card/item!");
            return;
        }
        if (battle.getActiveAccount().getPlayerCollection().getItems().size() == 3 && availablecard instanceof Item) {
            System.out.println("You can't have more than 3 items in your collection.");
            return;
        }
        if (availablecard instanceof Hero) {
            battle.getActiveAccount().getPlayerCollection().getHeroes().add((Hero) availablecard);
        } else if (availablecard instanceof Item) {
            battle.getActiveAccount().getPlayerCollection().getItems().add((Item) availablecard);
        } else if (availablecard instanceof Minion) {
            battle.getActiveAccount().getPlayerCollection().getMinions().add((Minion) availablecard);
        } else if (availablecard instanceof Spell) {
            battle.getActiveAccount().getPlayerCollection().getSpells().add((Spell) availablecard);
        }
        battle.getActiveAccount().setMoney(battle.getActiveAccount().getMoney() - availablecard.getCost());
    }*/

    /*public void sell(String cardID) {
        for (Hero hero : battle.getActiveAccount().getPlayerCollection().getHeroes()) {
            if (hero.getCardID().equals(cardID)) {
                battle.getActiveAccount().setMoney(battle.getActiveAccount().getMoney() + hero.getCost());
                battle.getActiveAccount().getPlayerCollection().getHeroes().remove(hero);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Item item : battle.getActiveAccount().getPlayerCollection().getItems()) {
            if (item.getCardID().equals(cardID)) {
                battle.getActiveAccount().setMoney(battle.getActiveAccount().getMoney() + item.getCost());
                battle.getActiveAccount().getPlayerCollection().getItems().remove(item);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Minion minion : battle.getActiveAccount().getPlayerCollection().getMinions()) {
            if (minion.getCardID().equals(cardID)) {
                battle.getActiveAccount().setMoney(battle.getActiveAccount().getMoney() + minion.getCost());
                battle.getActiveAccount().getPlayerCollection().getMinions().remove(minion);
                System.out.println("successful task :)");
                return;
            }
        }
        for (Spell spell : battle.getActiveAccount().getPlayerCollection().getSpells()) {
            if (spell.getCardID().equals(cardID)) {
                battle.getActiveAccount().setMoney(battle.getActiveAccount().getMoney() + spell.getCost());
                battle.getActiveAccount().getPlayerCollection().getSpells().remove(spell);
                System.out.println("successful task :)");
                return;
            }
        }
        System.out.println("You don't have this card/item! :(");
    }*/

    /*public void show() {
        int i = 0;
        System.out.println("Heroes :");
        for (Hero hero : allAvailableHeros) {
            View.showcardInfoWithCost(hero, i);
            i++;
        }
        i = 0;
        System.out.println("Items :");
        for (Item item : allAvailableItems) {
            View.showcardInfoWithCost(item, i);
            i++;
        }
        i = 0;
        System.out.println("Cards :");
        for (Minion minion : allAvailableMinions) {
            View.showcardInfoWithCost(minion, i);
            i++;
        }
        for (Spell spell : allAvailableSpells) {
            View.showcardInfoWithCost(spell, i);
            i++;
        }
    }*/


    @Override
    public void help(Stage primaryStage) {

    }

}
