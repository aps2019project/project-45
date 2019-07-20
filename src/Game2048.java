import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Game2048 extends Application {
    private static int n = 4;

    public static void main(String[] args) {
        handleSaves();
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Group group = new Group();
        Scene scene1 = new Scene(root, 1000, 700);
        Scene scene2 = new Scene(group, 1000, 700);
        root.setStyle("-fx-font-size: 15");
        primaryStage.setScene(scene1);
        primaryStage.show();
        Random random = new Random();

        Button exit = new Button("Exit");
        exit.setOnAction(event -> System.exit(-1));
        exit.setLayoutX(900);
        exit.setLayoutY(650);
        root.getChildren().add(exit);

        TextField text = new TextField();
        text.setLayoutX(400);
        text.setLayoutY(330);
        root.getChildren().add(text);

        Button back = new Button("back");
        back.setLayoutX(900);
        back.setLayoutY(650);
        back.setOnAction(event -> {
            primaryStage.setScene(scene1);

        });
        group.getChildren().add(back);

        ArrayList<ArrayList<Rectangle>> rec = new ArrayList<>();
        ArrayList<ArrayList<Label>> lab = new ArrayList<>();
        Button play = new Button("Play");
        play.setOnAction(event -> {
            rec.clear();
            lab.clear();
            if (!text.getText().equals("")) n = Integer.valueOf(text.getText());
            primaryStage.setScene(scene2);
            int first = random.nextInt(n * n - 1);
            int second = random.nextInt(n * n - first) + first;
            while (second == first) second = random.nextInt(n * n);
            int count = 0;
            for (int i = 0; i < n; i++) {
                ArrayList<Rectangle> smallRec = new ArrayList<>();
                ArrayList<Label> smallLab = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    Rectangle rectangle = new Rectangle();
                    Label label = new Label();

                    rectangle.setWidth(75);
                    rectangle.setHeight(75);
                    rectangle.setX(100 + j * 80);
                    rectangle.setY(100 + i * 80);
                    rectangle.setFill(Color.WHITE);
                    rectangle.setStroke(Color.BLACK);
                    label.setLayoutX(120 + j * 80);
                    label.setLayoutY(120 + i * 80);
                    label.setStyle("-fx-font-size: 25");
                    if (count == first || count == second) {
                        label.setText("2");
                        rectangle.setFill(Color.web("ffffc8"));
                    }
                    count++;
                    smallRec.add(rectangle);
                    smallLab.add(label);
                    group.getChildren().addAll(rectangle, label);
                }
                rec.add(smallRec);
                lab.add(smallLab);
            }
        });
        play.setLayoutX(800);
        play.setLayoutY(650);
        root.getChildren().add(play);

        scene2.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    for (int j = n - 2; j >= 0; j--) {
                        for (int i = 0; i < n; i++) {
                            int finalI = i;
                            int finalJ = j;
                            if (!lab.get(i).get(j).getText().equals("")) {

                                Rectangle copyRec = rec.get(finalI).get(finalJ);
                                Rectangle rectangle = new Rectangle(copyRec.getX(), copyRec.getY(), copyRec.getWidth(),
                                        copyRec.getHeight());
                                rectangle.setFill(copyRec.getFill());
                                Label copyLab = lab.get(finalI).get(finalJ);
                                Label label = new Label(copyLab.getText());
                                label.setLayoutX(10);
                                label.setLayoutY(10);
                                label.setStyle(copyLab.getStyle());
                                StackPane stackPane = new StackPane(rectangle, label);
                                stackPane.setAlignment(Pos.CENTER);
                                stackPane.setLayoutX(rectangle.getX());
                                stackPane.setLayoutY(rectangle.getY());
                                //stackPane.setMaxWidth(rectangle.getWidth());
                                //stackPane.setMaxHeight(rectangle.getHeight());
                                group.getChildren().add(stackPane);
                                TranslateTransition anim = new TranslateTransition();
                                anim.setNode(stackPane);
                                anim.setDuration(Duration.millis(300));
                                Multi multi = new Multi(anim, lab, rec, finalI, finalJ, n);
                                multi.start();
                            /*if (lab.get(i).get(j + 1).getText().equals("")) {

                            } else if (Integer.parseInt(lab.get(i).get(j).getText()) == Integer.parseInt(lab.
                                    get(i).get(j + 1).getText())) {

                            }*/
                            }
                        }
                    }
                    break;
                case LEFT:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                        }
                    }
                    break;
                case UP:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                        }
                    }
                    break;
                case DOWN:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                        }
                    }
                    break;
            }
        });

        scene2.setOnMouseClicked(event -> {
            String string = event.getX() + " , " + event.getY();
            System.out.println(string);
        });
    }

    private static void handleSaves() {

    }

    private void setColor(Label label, Rectangle rectangle) {
        switch (Integer.parseInt(label.getText())) {
            case 2:
                rectangle.setFill(Color.web("#ffffc8"));
                break;
            case 4:
                rectangle.setFill(Color.web("#ffff96"));
                break;
            case 8:
                rectangle.setFill(Color.web("#ffff64"));
                break;
            case 16:
                rectangle.setFill(Color.web("#ffff32"));
                break;
            case 32:
                rectangle.setFill(Color.web("#ffc8ff"));
                break;
            case 64:
                rectangle.setFill(Color.web("#ffc8c8"));
                break;
            case 128:
                rectangle.setFill(Color.web("#ffc896"));
                break;
            case 256:
                rectangle.setFill(Color.web("#ffc864"));
                break;
            case 512:
                rectangle.setFill(Color.web("#ffc832"));
                break;
            case 1024:
                rectangle.setFill(Color.web("#ffc800"));
                break;
            case 2048:
                rectangle.setFill(Color.web("#ff96ff"));
                break;
        }
    }
}

class Player {
    String username;
    String password;
}

class Multi extends Thread {
    private TranslateTransition anim;
    private ArrayList<ArrayList<Label>> lab;
    private ArrayList<ArrayList<Rectangle>> rec;
    private int finalI;
    private int finalJ;
    private int n;

    Multi(TranslateTransition anim, ArrayList<ArrayList<Label>> lab, ArrayList<ArrayList<Rectangle>> rec,
          int finalI, int finalJ, int n) {
        this.anim = anim;
        this.lab = lab;
        this.rec = rec;
        this.finalI = finalI;
        this.finalJ = finalJ;
        this.n = n;
    }

    public void run() {
        for (int k = finalJ + 1; k < n; k++) {
            if (lab.get(finalI).get(k).getText().equals("") && k != n - 1) continue;
            if ((lab.get(finalI).get(k).getText().equals("") && k == n - 1)) {
                anim.setByX(80 * (k - finalJ));
                anim.play();
                lab.get(finalI).get(finalJ).setText("");
                rec.get(finalI).get(finalJ).setFill(Color.WHITE);
                break;
            }
        }
    }
}