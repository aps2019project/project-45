package view;

import model.Account;
import model.Item;
import view.menus.Menus;

import java.util.ArrayList;

public class Battle extends Menus {
    private static Account[] actvieAccounts = new Account[2];
    private static ArrayList<Item> flags = new ArrayList<>();

    public static void setAnActiveAccount(Account account){
        if (actvieAccounts[0] == null) {
            actvieAccounts[0] = account;
            return;
        }
        actvieAccounts[1] = account;
    }
    public void gameInfo(int mode) {
        System.out.println(actvieAccounts[0].getUserName() + " mana : " + actvieAccounts[0].getMana());
        System.out.println(actvieAccounts[1].getUserName() + " mana : " + actvieAccounts[1].getMana());
        switch (mode) {
            case 1:
                System.out.println(actvieAccounts[0].getUserName() + " health : " + actvieAccounts[0].getHero().getHealth());
                System.out.println(actvieAccounts[1].getUserName() + " health : " + actvieAccounts[0].getHero().getHealth());
                break;
            case 2:
                System.out.printf("flag is in (%d , %d) house.\n", flags.get(0).getX(), flags.get(0).getY());
                if (flags.get(0).getOwner() == null) System.out.println("Flag isn't owned by any player!");
                else
                    System.out.printf("flag owner is %s from player %s\n", flags.get(0).getOwner().getCardID() ,
                            flags.get(0).getUserAccountOwner().getUserName());
                break;
            case 3:
                System.out.println("owners of flags : ");
                for (int i = 0; i < flags.size(); i++) {
                    System.out.printf("%d. %s from player %s\n", i + 1 , flags.get(i).getOwner().getCardID() ,
                            flags.get(i).getUserAccountOwner().getUserName());
                }
                break;
        }
    }
    public void showMyMinions(boolean turn){
        Account account;
        if (turn) account = actvieAccounts[0];
        else account = actvieAccounts[1];
        System.out.printf("%s : %s, health : %d, location : (%d, %d), power : %d \n", account.getHero().getCardID() ,
                account.getHero().getName() , account.getHero().getHealth() , account.getHero().getX() , account.getHero().getY() ,
                account.getHero().getAP());
    }

    @Override
    public void help() {
        System.out.print("Game info\n");
    }
}
