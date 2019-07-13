package view.menus;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;
import view.Battle;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shop extends Menu {
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

        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;
        Image image5 = null;
        Image image6 = null;
        try {
            image1 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back@2x.png"));
            image2 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back_shimzar@2x.png"));
            image3 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back_magma@2x.png"));
            image4 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back_snowchaser@2x.png"));
            image5 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back_lyonar_gears@2x.png"));
            image6 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\card_backgrounds\\card_back_humble_bundle@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        ImageView imageView5 = new ImageView(image5);
        ImageView imageView6 = new ImageView(image6);
        imageView1.setFitWidth(150);
        imageView2.setFitWidth(150);
        imageView3.setFitWidth(150);
        imageView4.setFitWidth(150);
        imageView5.setFitWidth(150);
        imageView6.setFitWidth(150);
        imageView1.setFitHeight(250);
        imageView2.setFitHeight(250);
        imageView3.setFitHeight(250);
        imageView4.setFitHeight(250);
        imageView5.setFitHeight(250);
        imageView6.setFitHeight(250);
        imageView1.setLayoutX(400);
        imageView4.setLayoutX(400);
        imageView2.setLayoutX(600);
        imageView5.setLayoutX(600);
        imageView3.setLayoutX(800);
        imageView6.setLayoutX(800);
        imageView1.setLayoutY(80);
        imageView4.setLayoutY(380);
        imageView2.setLayoutY(80);
        imageView5.setLayoutY(380);
        imageView3.setLayoutY(80);
        imageView6.setLayoutY(380);

        imageView1.setOnMouseClicked(event -> {
            System.out.println(100);
        });

        root.getChildren().addAll(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6);

        primaryStage.show();
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
