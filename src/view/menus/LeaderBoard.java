package view.menus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;

public class LeaderBoard extends Menu {
    private static final LeaderBoard LEADER_BOARD = new LeaderBoard();
    private LeaderBoard() {}
    public static LeaderBoard getInstance() { return LEADER_BOARD; }

    @Override
    public void help(Stage primaryStage) {

    }

    @Override
    public void open(Stage primaryStage) {
        Group root = (Group) primaryStage.getScene().getRoot();

        Image image = null;
        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        try {
            image = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources\\app" +
                    "\\src\\resources\\scenes\\magaari_ember_highlands\\magaari_ember_highlands_background@2x.jpg"));
            image1 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\scenes\\magaari_ember_highlands\\magaari_ember_highlands_foreground@2x.png"));
            image2 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\scenes\\magaari_ember_highlands\\magaari_ember_highlands_middleground@2x.png"));
            image3 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\scenes\\magaari_ember_highlands\\magaari_ember_highlands_trees_002@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        imageView1.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()*3/4);
        imageView1.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/4);
        imageView1.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()/3);
        imageView1.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*2/3);
        imageView2.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/2);
        imageView2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/2);
        imageView2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
        imageView3.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()*5/7);
        imageView3.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/7);
        imageView3.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/2);
        imageView3.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setLayoutX(500);
        grid.setLayoutY(150);

        TableView table = new TableView();

        table.setEditable(true);

        TableColumn<String, Account> username = new TableColumn<>("username");
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn<Integer, Account> win = new TableColumn<>("Win");
        win.setCellValueFactory(new PropertyValueFactory<>("wins"));

        username.setMinWidth(200);
        win.setMinWidth(200);
        username.setStyle("-fx-alignment: CENTER; -fx-font-size:20");
        win.setStyle("-fx-alignment: CENTER; -fx-font-size:20");


        AccountMenu.accounts.sort(new AccountWinComparator());
        ObservableList<Account> data = FXCollections.observableArrayList();
        data.addAll(AccountMenu.accounts);

        table.setMaxWidth(username.getWidth() + win.getWidth());
        table.setStyle("-fx-background-color: #0b7aaa");
        table.setBackground(Background.EMPTY);
        table.setStyle("-fx-border-color: black");

        Button exit = (Button) root.getChildren().get(0);
        Button help = (Button) root.getChildren().get(1);
        root.getChildren().remove(exit);
        root.getChildren().remove(help);

        table.getColumns().addAll(username, win);
        table.setItems(data);
        grid.add(table, 0, 0);

        root.getChildren().addAll(imageView, imageView3, imageView2, imageView1, grid, exit, help);
        primaryStage.show();
    }
}


class AccountWinComparator implements Comparator<Account> {

    public int compare(Account account1, Account account2) {
        return Integer.compare(account1.getWins() , account2.getWins());
    }

}