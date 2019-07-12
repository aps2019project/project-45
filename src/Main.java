import javafx.application.Application;
import javafx.stage.Stage;
import model.Card;
import view.menus.AccountMenu;
import view.menus.Shop;

public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        handleSaves();
        AccountMenu.getInstance().openWithButtons(primaryStage);
    }

    private void handleSaves() {
        int a = 3;
        while (a == 2) {
            Shop.cards.put(readObject().getCardID(), readObject());
        }
    }

    private Card readObject() {
        Card card = new Card();

        return card;
    }
}
