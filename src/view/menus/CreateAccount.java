package view.menus;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Account;
import view.Battle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CreateAccount extends PlayMenu {
    private static final CreateAccount CREATE_ACCOUNT = new CreateAccount();
    private CreateAccount() { }
    public static CreateAccount getInstance() {
        return CREATE_ACCOUNT;
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
            image = new Image(new FileInputStream("bg@2x.jpg"));
            image1 = new Image(new FileInputStream("midground@2x.png"));
            image2 = new Image(new FileInputStream("foreground1@2x.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        imageView1.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView1.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        imageView2.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/3);
        imageView2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()*2/3);
        imageView2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*2/5);
        imageView2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()*3/5);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setLayoutX(500);
        grid.setLayoutY(300);
        grid.setVgap(15);
        grid.setHgap(15);
        primaryStage.setTitle("Create Account Menu");
        primaryStage.show();

        Label usernameLabel = new Label("username :");
        Label passwordLabel = new Label("Password :");
        Label confirmPasswordLabel = new Label("Confirm Password :");
        Label error = new Label();

        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();

        Button create = new Button("Create");

        create.setStyle("-fx-font-size: 15");

        usernameLabel.setStyle("-fx-font-size: 15; -fx-background-color: #09dedc; -fx-border-color: black");
        passwordLabel.setStyle("-fx-font-size: 15; -fx-background-color: #09dedc; -fx-border-color: black");
        confirmPasswordLabel.setStyle("-fx-font-size: 15; -fx-background-color: #09dedc; -fx-border-color: black");
        usernameLabel.setMaxWidth(Double.MAX_VALUE);
        usernameLabel.setAlignment(Pos.CENTER);
        passwordLabel.setMaxWidth(Double.MAX_VALUE);
        passwordLabel.setAlignment(Pos.CENTER);
        confirmPasswordLabel.setMaxWidth(Double.MAX_VALUE);
        
        error.setLayoutX(grid.getLayoutX());
        error.setLayoutY(grid.getLayoutY() - 30);
        error.setStyle("-fx-text-fill: red; -fx-font-size: 15; -fx-background-color: #40403F");
        error.setVisible(false);

        grid.add(usernameLabel, 0, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(confirmPasswordLabel, 0, 2);
        grid.add(usernameTextField, 1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(confirmPasswordField, 1, 2);
        grid.add(create, 0, 3);

        Button exit = (Button) root.getChildren().get(0);
        Button help = (Button) root.getChildren().get(1);
        root.getChildren().remove(exit);
        root.getChildren().remove(help);

        root.getChildren().addAll(imageView, imageView1, imageView2, grid, error, exit, help);

        usernameTextField.setOnKeyPressed(event ->
                usernameTextField.setTextFormatter(new TextFormatter<>(change -> {
                    if (event.getCode() != KeyCode.ENTER) {
                        for (Account account : AccountMenu.accounts) {
                            if (account.getUsername().equals(change.getControlNewText())) {
                                error.setText("This username has already existed!");
                                error.setVisible(true);
                                break;
                            }
                        }
                    }
                    return change;
                })));


        create.setOnAction(event -> {
            error.setVisible(false);
            if (usernameTextField.getText().equals("")) {
                error.setText("username field is empty.");
                error.setVisible(true);
                return;
            }
            if (usernameTextField.getText().contains(" ")) {
                error.setText("username field can't accept space!");
                error.setVisible(true);
                return;
            }
            if (passwordField.getText().equals("")) {
                error.setText("Password field is empty.");
                error.setVisible(true);
                return;
            }
            if (confirmPasswordField.getText().equals("")) {
                error.setText("Confirm password field is empty.");
                error.setVisible(true);
                return;
            }
            if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                error.setText("Password field and Confirm password field are incompatible!");
                error.setVisible(true);
                return;
            } else {
                Account account = new Account(usernameTextField.getText(), passwordField.getText());
                AccountMenu.accounts.add(account);
                account.setActiveAtTheMoment(true);
                if (BATTLE.getBattlePlayers()[0] == null) {
                    BATTLE.getBattlePlayers()[0] = account;
                } else {
                    BATTLE.getBattlePlayers()[1] = account;
                    BATTLE.getBattlePlayers()[0].setActiveAtTheMoment(false);
                }
                MainMenu.getInstance().lastMenu = CreateAccount.getInstance();
                MainMenu.getInstance().openWithButtons(primaryStage);
            }
        });
    }
}
