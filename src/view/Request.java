package view;

import view.menus.Menus;

import java.util.Scanner;

public class Request {
    private static Scanner scanner = new Scanner(System.in);
    private String command;
    private Menus relatedMenu;//probability of error

    public Request(Menus relatedMenu) {
        this.relatedMenu = relatedMenu;
    }
    public Menus getRelatedMenu() {
        return relatedMenu;
    }
    public void setNewCommand(){
        this.command = scanner.nextLine();
    }
    public String getCommand() {
        return command;
    }

}
