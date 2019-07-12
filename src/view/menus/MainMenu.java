package view.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import view.Battle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu extends Menu {
    private static final MainMenu MAIN_MENU = new MainMenu();
    private MainMenu() {
    }
    public static MainMenu getInstance() {
        return MAIN_MENU;
    }

    private static Battle BATTLE = Battle.getInstance();

    @Override
    public void help(Stage primaryStage) {

    }

    @Override
    public void open(Stage primaryStage) {
        Group root = (Group) primaryStage.getScene().getRoot();

        Image image = null;
        Image image1 = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources\\" +
                    "app\\src\\resources\\scenes\\obsidian_woods\\obsidian_woods_background@2x.jpg"));
            image1 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\scenes\\obsidian_woods\\obsidian_woods_cliff@2x.png"));
            image2 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\resources" +
                    "\\app\\src\\resources\\scenes\\obsidian_woods\\obsidian_woods_pillar@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        imageView1.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView1.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*3/5);
        imageView1.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()*2/5);

        imageView2.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()*6/7);
        imageView2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/7);
        imageView2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
        imageView2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*2/7);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setLayoutX(650);
        vBox.setLayoutY(250);

        Button collecttion = new Button("Collection");
        Button shop = new Button("Shop");
        Button battle = new Button("Battle");
        Button customCard = new Button("Custom Card");

        collecttion.setStyle("-fx-font-size: 20; -fx-background-color: #09dedc; -fx-border-color: black");
        shop.setStyle("-fx-font-size: 20; -fx-background-color: #09dedc; -fx-border-color: black");
        battle.setStyle("-fx-font-size: 20; -fx-background-color: #09dedc; -fx-border-color: black");
        customCard.setStyle("-fx-font-size: 20; -fx-background-color: #09dedc; -fx-border-color: black");
        collecttion.setMaxWidth(Double.MAX_VALUE);
        shop.setMaxWidth(Double.MAX_VALUE);
        battle.setMaxWidth(Double.MAX_VALUE);
        customCard.setMaxWidth(Double.MAX_VALUE);

        Button exit = (Button) root.getChildren().get(0);
        Button help = (Button) root.getChildren().get(1);
        root.getChildren().remove(exit);
        root.getChildren().remove(help);

        vBox.getChildren().addAll(collecttion, shop, battle, customCard);
        root.getChildren().addAll(imageView, imageView2, imageView1, vBox, exit, help);

        collecttion.setOnAction(event -> BATTLE.getActiveAccount().getPlayerCollection().openWithButtons(primaryStage));
        shop.setOnAction(event -> Shop.getInstance().openWithButtons(primaryStage));
        battle.setOnAction(event -> {
            if (BATTLE.getBattlePlayers()[1] == null) {
                PlayingTypeMenu.getInstance().lastMenu = MainMenu.getInstance();
                PlayingTypeMenu.getInstance().openWithButtons(primaryStage);
            } else {
                BATTLE.lastMenu = MainMenu.getInstance();
                BATTLE.openWithButtons(primaryStage);
            }
        });
        customCard.setOnAction(event -> {
            CustomCardMenu.getInstance().lastMenu = MainMenu.getInstance();
            CustomCardMenu.getInstance().openWithButtons(primaryStage);
        });
    }

}
