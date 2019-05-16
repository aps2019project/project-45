package view.menus;

import model.Card;
import model.MenuType;

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
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.GRAVE_YARD;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Grave Yard " +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

}
