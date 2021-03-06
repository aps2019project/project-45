package view.menus;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class PlayerCollection extends PlayMenu {
    private static HashMap<String, Map<String, Card>> decks = new HashMap<>();

    //private String selectedDeckName;
    private Map<String, Card> heroes = new HashMap<>();
    private Map<String, Card> minions = new HashMap<>();
    private Map<String, Card> spells = new HashMap<>();
    private Map<String, Card> items = new HashMap<>();

    private Account player;

    @Override
    public void open(Stage primaryStage) {
        Group root = (Group) primaryStage.getScene().getRoot();

        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;
        Image image5 = null;
        Image image6 = null;
        try {
            image1 = new Image(new FileInputStream("card_back@2x.png"));
            image2 = new Image(new FileInputStream("card_back_shimzar@2x.png"));
            image3 = new Image(new FileInputStream("card_back_magma@2x.png"));
            image4 = new Image(new FileInputStream("card_back_snowchaser@2x.png"));
            image5 = new Image(new FileInputStream("card_back_lyonar_gears@2x.png"));
            image6 = new Image(new FileInputStream("card_back_humble_bundle@2x.png"));
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

        MenuBar menubar = new MenuBar();
        Menu heroMenu = new Menu("Hero");
        Menu minionMenu = new Menu("Minion");
        Menu spellMenu = new Menu("Spell");
        Menu itemMenu = new Menu("Item");
        menubar.getMenus().addAll(heroMenu, minionMenu, spellMenu, itemMenu);

        root.getChildren().addAll(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6);

        primaryStage.show();
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
