package view;

import view.menus.Menu;

import java.util.Scanner;

public class Request {
    private Scanner scanner = new Scanner(System.in);
    private String command;
    private Menu relatedMenu;//probability of error

    public Request(Menu relatedMenu) {
        this.relatedMenu = relatedMenu;
    }
    public Menu getRelatedMenu() {
        return relatedMenu;
    }
    public void setNewCommand(){
        this.command = scanner.nextLine();
    }
    public String getCommand() {
        return command;
    }

    public boolean exitOrHelp(Menu menu , String exitOrHelp) {
        if (exitOrHelp.equalsIgnoreCase("exit")) {
            menu.exit();
            return false;
        } else if (exitOrHelp.equalsIgnoreCase("help")) {
            menu.help();
            return true;
        }
        return true;
    }
}