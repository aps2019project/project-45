package model;

import java.util.ArrayList;

public class Battle {
    private static ArrayList<Account> activeAccounts = new ArrayList<>();

    public static void setAnActiveAccount(Account account){
        activeAccounts.add(account);
    }

}
