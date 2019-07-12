package view.menus;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.Screen;
import model.Account;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccountMenu extends Menu {
    private static final AccountMenu ACCOUNT_MENU = new AccountMenu();
    private AccountMenu() {}
    public static AccountMenu getInstance() {
        return ACCOUNT_MENU;
    }

    static ArrayList<Account> accounts = new ArrayList<>();


    @Override
    public void help(Stage primaryStage){
    }

    @Override
    public void exit(Stage primaryStage) {
        System.exit(0);
    }

    @Override
    public void open(Stage primaryStage) {
        Group root = (Group) primaryStage.getScene().getRoot();

        VBox vbox = new VBox();

        Image image = null;
        Image image1 = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\" +
                    "resources\\app\\src\\resources\\scenes\\frostfire\\background@2x.jpg"));
            image1 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\" +
                    "resources\\app\\src\\resources\\scenes\\frostfire\\pillars_near@2x.png"));
            image2 = new Image(new FileInputStream("C:\\BANDAI NAMCO Entertainment America\\Duelyst\\" +
                    "resources\\app\\src\\resources\\scenes\\frostfire\\foreground@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        imageView1.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*1/5);
        imageView1.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/2);
        imageView1.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()*4/5);
        imageView2.setLayoutX(imageView1.getFitWidth()*2/3);
        imageView2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight() - imageView1.getFitHeight()/2);
        imageView2.setFitWidth(imageView1.getFitWidth()*3/2);
        imageView2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight() - imageView1.getFitHeight()/2);

        Media media = new Media(new File("m.m4a").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView();
        mediaView.setMediaPlayer(mediaPlayer);

        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(600);
        vbox.setLayoutY(250);

        Label error = new Label("No account has been saved yet!");
        Button createAccount = new Button("Create Account");
        Button login = new Button("Login");
        Button showLeaderBoard = new Button("Leaderboard");

        createAccount.setStyle("-fx-font-size: 20; -fx-background-color: #09dedc; -fx-border-color: black");
        login.setStyle("-fx-font-size:20; -fx-background-color: #09dedc; -fx-border-color: black");
        showLeaderBoard.setStyle("-fx-font-size:20; -fx-background-color: #09dedc; -fx-border-color: black");
        createAccount.setMaxWidth(Double.MAX_VALUE);
        login.setMaxWidth(Double.MAX_VALUE);
        showLeaderBoard.setMaxWidth(Double.MAX_VALUE);
        error.setVisible(false);
        error.setStyle("-fx-text-fill: red; -fx-font-size: 15; -fx-background-color: #40403F");

        createAccount.setOnAction(event -> {
            //mediaPlayer.stop();
            CreateAccount.getInstance().lastMenu = AccountMenu.getInstance();
            CreateAccount.getInstance().openWithButtons(primaryStage);
        });
        login.setOnAction(event -> {
            if (AccountMenu.accounts.size() != 0) {
                //mediaPlayer.stop();
                Login.getInstance().lastMenu = AccountMenu.getInstance();
                Login.getInstance().openWithButtons(primaryStage);
            } else {
                error.setVisible(true);
            }
        });
        showLeaderBoard.setOnAction(event -> {
            //mediaPlayer.stop();
            LeaderBoard.getInstance().lastMenu = AccountMenu.getInstance();
            LeaderBoard.getInstance().openWithButtons(primaryStage);
        });

        Button exit = (Button) root.getChildren().get(0);
        Button help = (Button) root.getChildren().get(1);
        root.getChildren().remove(exit);
        root.getChildren().remove(help);

        vbox.getChildren().addAll(error, createAccount, login, showLeaderBoard);
        root.getChildren().addAll(mediaView, imageView, imageView1, imageView2, vbox, exit, help);

        primaryStage.setTitle("Account Menu");
        primaryStage.show();
    }


}
