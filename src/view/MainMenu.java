package view;

public class MainMenu {
    private static final MainMenu mainMenu = new MainMenu();
    private MainMenu(){}
    public static MainMenu getInstance(){
        return mainMenu;
    }

}
