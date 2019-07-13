package view.menus;

import controller.PlayController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import model.Account;
import view.Battle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Login extends Menu {
    private static final Login LOGIN = new Login();
    private Login() {
    }
    public static Login getInstance() {
        return LOGIN;
    }

    private Battle battle = Battle.getInstance();

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
            image = new Image(new FileInputStream("bg1@2x.jpg"));
            image1 = new Image(new FileInputStream("midground1@2x.png"));
            image2 = new Image(new FileInputStream("foreground2@2x.png"));
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
        imageView2.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/4);
        imageView2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()*3/4);
        imageView2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()*2/3);
        imageView2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()*1/3);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setLayoutX(500);
        grid.setLayoutY(300);
        grid.setVgap(15);
        grid.setHgap(15);

        Label username = new Label("username : ");
        Label password = new Label("Password : ");
        Label error = new Label();
        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");

        username.setStyle("-fx-font-size: 15; -fx-background-color: #09dedc; -fx-border-color: black");
        password.setStyle("-fx-font-size: 15; -fx-background-color: #09dedc; -fx-border-color: black");
        error.setStyle("-fx-font-size: 15; -fx-text-fill: red; -fx-background-color: #40403f; -fx-border-color: black");
        username.setMaxWidth(Double.MAX_VALUE);
        username.setAlignment(Pos.CENTER);
        password.setMaxWidth(Double.MAX_VALUE);
        password.setAlignment(Pos.CENTER);
        error.setLayoutX(grid.getLayoutX());
        error.setLayoutY(grid.getLayoutY() - 30);
        error.setVisible(false);
        login.setStyle("-fx-font-size: 15");

        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(usernameTextField, 1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(login, 0, 2);

        Button exit = (Button) root.getChildren().get(0);
        Button help = (Button) root.getChildren().get(1);
        root.getChildren().remove(exit);
        root.getChildren().remove(help);

        root.getChildren().addAll(imageView, imageView1, imageView2, grid, error, exit, help);

        login.setOnAction(event -> {
            error.setVisible(false);
            if (usernameTextField.getText().equals("")) {
                error.setText("username field is empty.");
                error.setVisible(true);
                return;
            }

            if (passwordField.getText().equals("")) {
                error.setText("Password field is empty.");
                error.setVisible(true);
                return;
            }
            for (Account account : AccountMenu.accounts) {
                if (account.getUsername().equals(usernameTextField.getText())) {
                    if (account.getPassWord().equals(passwordField.getText())) {
                        account.setActiveAtTheMoment(true);
                        if (battle.getBattlePlayers()[0] == null) {
                            battle.getBattlePlayers()[0] = account;
                        } else {
                            battle.getBattlePlayers()[0].setActiveAtTheMoment(false);
                            battle.getBattlePlayers()[1] = account;
                        }
                        MainMenu.getInstance().lastMenu = Login.getInstance();
                        MainMenu.getInstance().openWithButtons(primaryStage);
                        return;
                    } else {
                        error.setText("Invalid password");
                        error.setVisible(true);
                    }
                }
            }
            error.setText("Invalid username");
            error.setVisible(true);
        });

        primaryStage.setTitle("Login");
        primaryStage.show();
    }

}
