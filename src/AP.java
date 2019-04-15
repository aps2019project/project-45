import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AP {

    public static ArrayList<String> accountNames = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
    }

}

class Account{
    private String name;

    public void createAccount(String s){
        if (AP.accountNames.contains(s)){
            System.out.println();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Pattern pattern1 = Pattern.compile("create account (\\w+)");

}