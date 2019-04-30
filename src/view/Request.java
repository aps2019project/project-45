package view;

import java.util.Scanner;

public class Request {
    //probability of error
    private Menus relatedMenu;
    //probability of error
    private static Scanner scanner = new Scanner(System.in);

    public Request(Menus relatedMenu) {
        this.relatedMenu = relatedMenu;
    }

    public static String getPassWordForLogin(){
        return scanner.nextLine();
    }

    public void accountMenuRequest(){

    }
}
