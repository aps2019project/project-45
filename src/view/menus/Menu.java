package view.menus;

import controller.PlayController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;

public abstract class Menu {
    public Menu lastMenu;
    public abstract void help(Stage primaryStage);
    public abstract void open(Stage primaryStage) throws LineUnavailableException;
    public void exit(Stage primaryStage) {
        lastMenu.openWithButtons(primaryStage);
    }

    public void openWithButtons(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().
                getVisualBounds().getHeight() - 30);
        primaryStage.setScene(scene);
        primaryStage.show();

        Button exit = new Button("exit");
        exit.setStyle("-fx-font-size: 15; -fx-border-color: black");
        exit.setLayoutX(1275);
        exit.setLayoutY(650);
        exit.setOnAction(event -> exit(primaryStage));
        root.getChildren().add(exit);

        Button help = new Button("help");
        help.setLayoutX(1200);
        help.setLayoutY(650);
        help.setStyle("-fx-font-size: 15; -fx-text-fill: blue; -fx-border-color: black");
        help.setOnAction(event -> help(primaryStage));
        root.getChildren().add(help);

        exit.setStyle("-fx-background-color: #702ea9");
        help.setStyle("-fx-background-color: #702ea9");
        try {
            open(primaryStage);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        scene.setOnMouseClicked(event -> {
            String string = event.getX() + " , " + event.getY();
            System.out.println(string);
        });
    }

}
