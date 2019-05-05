package view.menus;

import model.Card;
import model.CardOrItem;
import model.MenuType;

import java.util.ArrayList;

public class GraveYard extends Menu {
    private ArrayList<Card> cards = new ArrayList<>();

    public void add(Card card){
        this.cards.add(card);
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.GRAVE_YARD;
    }

}
