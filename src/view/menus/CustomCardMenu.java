package view.menus;

import model.Card;
import model.MenuType;
import view.Request;

public class CustomCardMenu extends Menu{

    private static final CustomCardMenu CUSTOM_CARD_MENU = new CustomCardMenu();
    private CustomCardMenu() {}
    public static CustomCardMenu getInstance() {return CUSTOM_CARD_MENU;}

    public void create() {
        Card created = new Card();
        System.out.print("name : ");
        Request nameRequest = new Request();
        nameRequest.setNewCommand();
        System.out.println("type : ");
        Request typeRequest = new Request();
        typeRequest.setNewCommand();
        if (typeRequest.getCommand().equalsIgnoreCase("spell")) {
            System.out.println("target : ");
            Request targetRequest = new Request();
            targetRequest.setNewCommand();

            Request endAddingBuffsRequest = new Request();
            do {

                System.out.println("buff type : ");
                Request buffTypeRequest = new Request();
                buffTypeRequest.setNewCommand();
                System.out.println("effect value : ");
                Request effectValueRequest = new Request();
                effectValueRequest.setNewCommand();
                System.out.println("delay : ");
                Request delayRequest = new Request();
                delayRequest.setNewCommand();
                System.out.println("last : ");
                Request lastRequest = new Request();
                lastRequest.setNewCommand();
                System.out.println("friend or enemy : ");
                Request friendOrEnemyRequest = new Request();
                friendOrEnemyRequest.setNewCommand();

                System.out.println("Do you want to add another buff?");
                endAddingBuffsRequest.setNewCommand();
            } while (endAddingBuffsRequest.getCommand().equalsIgnoreCase("yes"));
        }
    }

    @Override
    public void help() {

    }

    @Override
    public MenuType getType() {
        return MenuType.CUSTOM_CARD_MENU;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Create " +
                "Custom Card Menu * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
