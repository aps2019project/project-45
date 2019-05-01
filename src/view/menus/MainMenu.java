package view.menus;

public class MainMenu extends Menus {
    static final String TYPE = "main menu";


    @Override
    public void help() {
        System.out.print("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Help");
    }

}
