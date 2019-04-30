package view;

import model.CardOrItem;

import java.util.ArrayList;

public class GraveYard extends Menus{
    private ArrayList<CardOrItem> cards;

    public void add(CardOrItem CardOrItem){
        this.cards.add(CardOrItem);
    }

    @Override
    public void help() {

    }
}
