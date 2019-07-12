package view.menus;

import javafx.stage.Stage;
import model.Card;

import java.util.ArrayList;

public class GraveYard extends Menu {
    private ArrayList<Card> cards = new ArrayList<>();

    public void add(Card card){
        this.cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void help(Stage primaryStage) {

    }

    @Override
    public void open(Stage primaryStage) {

    }

    @Override
    public void exit(Stage primaryStage) {

    }

}
