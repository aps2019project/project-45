import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
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
    private static int newRandomX;
    private static int newRandomY;

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
        back.setStyle("-fx-font-size: 15");
        back.setOnAction(event -> primaryStage.setScene(scene1));
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
            while (second == first) second = random.nextInt(n * n - first) + first;
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
            //lab.get(3).get(0).setText("4");
            //lab.get(2).get(0).setText("4");
            //lab.get(3).get(2).setText("2");

        });
        play.setLayoutX(800);
        play.setLayoutY(650);
        root.getChildren().add(play);

        scene2.setOnKeyPressed(event -> {
            TranslateTransition anim = null;
            switch (event.getCode()) {
                case RIGHT:
                    for (int j = n - 2; j >= 0; j--) {
                        for (int i = 0; i < n; i++) {
                            int finalI = i;
                            if (!lab.get(i).get(j).getText().equals("")) {
                                Rectangle copyRec = rec.get(i).get(j);
                                Rectangle rectangle = new Rectangle(copyRec.getX(), copyRec.getY(), copyRec.
                                        getWidth(), copyRec.getHeight());
                                rectangle.setFill(copyRec.getFill());
                                rectangle.setStroke(Color.BLACK);
                                Label label = new Label(lab.get(i).get(j).getText());
                                label.setLayoutX(15);
                                label.setLayoutY(10);
                                label.setStyle(lab.get(i).get(j).getStyle());
                                StackPane stackPane = new StackPane(rectangle, label);
                                stackPane.setAlignment(Pos.CENTER);
                                stackPane.setLayoutX(rectangle.getX());
                                stackPane.setLayoutY(rectangle.getY());
                                group.getChildren().add(stackPane);
                                anim = new TranslateTransition();
                                anim.setNode(stackPane);
                                anim.setDuration(Duration.millis(300));
                                for (int k = j + 1; k < n; k++) {
                                    int finalK = k;
                                    if (lab.get(i).get(k).getText().equals("") && k != n - 1) continue;
                                    if (lab.get(i).get(k).getText().equals("") && k == n - 1 && k != j) {
                                        anim.setByX(80 * (k - j));
                                        anim.play();
                                        lab.get(i).get(k).setText(lab.get(i).get(j).getText());
                                        lab.get(i).get(k).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        Color color = (Color) rec.get(finalI).get(j).getFill();
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalI).get(finalK).setVisible(true);
                                            rec.get(finalI).get(finalK).setFill(color);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) != Integer.parseInt(lab.get(i).
                                            get(k).getText())) {
                                        anim.setByX(80 * (k - j - 1));
                                        anim.play();
                                        lab.get(i).get(k - 1).setText(lab.get(i).get(j).getText());
                                        lab.get(i).get(k - 1).setVisible(false);
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        if (k - j != 1) {
                                            lab.get(i).get(j).setText("");
                                            rec.get(i).get(j).setFill(Color.WHITE);
                                        }
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            rec.get(finalI).get(finalK - 1).setFill(color);
                                            lab.get(finalI).get(finalK - 1).setVisible(true);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) == Integer.parseInt(lab.get(i).
                                            get(k).getText())) {
                                        anim.setByX(80 * (k - j));
                                        anim.play();
                                        int a = 2 * Integer.parseInt(lab.get(i).get(j).getText());
                                        lab.get(i).get(k).setText(Integer.toString(a));
                                        lab.get(i).get(k).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalI).get(finalK).setVisible(true);
                                            setColor(lab.get(finalI).get(finalK), rec.get(finalI).get(finalK));
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    random2or4(lab, rec);
                    break;
                case LEFT:
                    for (int j = 1; j < n; j++) {
                        for (int i = 0; i < n; i++) {
                            int finalI = i;
                            int finalJ = j;
                            if (!lab.get(i).get(j).getText().equals("")) {
                                Rectangle copyRec = rec.get(finalI).get(finalJ);
                                Rectangle rectangle = new Rectangle(copyRec.getX(), copyRec.getY(), copyRec.
                                        getWidth(), copyRec.getHeight());
                                rectangle.setFill(copyRec.getFill());
                                rectangle.setStroke(Color.BLACK);
                                Label label = new Label(lab.get(finalI).get(finalJ).getText());
                                label.setLayoutX(15);
                                label.setLayoutY(10);
                                label.setStyle(lab.get(finalI).get(finalJ).getStyle());
                                StackPane stackPane = new StackPane(rectangle, label);
                                stackPane.setAlignment(Pos.CENTER);
                                stackPane.setLayoutX(rectangle.getX());
                                stackPane.setLayoutY(rectangle.getY());
                                group.getChildren().add(stackPane);
                                anim = new TranslateTransition();
                                anim.setNode(stackPane);
                                anim.setDuration(Duration.millis(300));
                                for (int k = finalJ - 1; k >= 0; k--) {
                                    int finalK = k;
                                    if (lab.get(i).get(k).getText().equals("") && k != 0) continue;
                                    if (lab.get(i).get(k).getText().equals("") && k == 0) {
                                        anim.setByX(80 * (k - j));
                                        anim.play();
                                        lab.get(i).get(k).setText(lab.get(i).get(j).getText());
                                        lab.get(i).get(k).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalI).get(finalK).setVisible(true);
                                            rec.get(finalI).get(finalK).setFill(color);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) != Integer.parseInt(lab.get(i).
                                            get(k).getText())) {
                                        anim.setByX(80 * (k - j + 1));
                                        anim.play();
                                        lab.get(i).get(k + 1).setText(lab.get(finalI).get(j).getText());
                                        lab.get(i).get(k + 1).setVisible(false);
                                        Color color = (Color) rec.get(finalI).get(finalJ).getFill();
                                        if (j - k != 1) {
                                            lab.get(i).get(j).setText("");
                                            rec.get(i).get(j).setFill(Color.WHITE);
                                        }
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            rec.get(finalI).get(finalK + 1).setFill(color);
                                            lab.get(finalI).get(finalK + 1).setVisible(true);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) == Integer.parseInt(lab.get(i).
                                            get(k).getText())) {
                                        anim.setByX(80 * (k - j));
                                        anim.play();
                                        int a = 2 * Integer.parseInt(lab.get(i).get(j).getText());
                                        lab.get(i).get(k).setText(Integer.toString(a));
                                        lab.get(i).get(k).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalI).get(finalK).setVisible(true);
                                            group.getChildren().remove(stackPane);
                                            setColor(lab.get(finalI).get(finalK), rec.get(finalI).get(finalK));
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    random2or4(lab, rec);
                    break;
                case UP:
                    for (int i = 1; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            int finalI = i;
                            int finalJ = j;
                            if (!lab.get(i).get(j).getText().equals("")) {
                                Rectangle copyRec = rec.get(finalI).get(finalJ);
                                Rectangle rectangle = new Rectangle(copyRec.getX(), copyRec.getY(), copyRec.
                                        getWidth(), copyRec.getHeight());
                                rectangle.setFill(copyRec.getFill());
                                rectangle.setStroke(Color.BLACK);
                                Label label = new Label(lab.get(finalI).get(finalJ).getText());
                                label.setLayoutX(15);
                                label.setLayoutY(10);
                                label.setStyle(lab.get(finalI).get(finalJ).getStyle());
                                StackPane stackPane = new StackPane(rectangle, label);
                                stackPane.setAlignment(Pos.CENTER);
                                stackPane.setLayoutX(rectangle.getX());
                                stackPane.setLayoutY(rectangle.getY());
                                group.getChildren().add(stackPane);
                                anim = new TranslateTransition();
                                anim.setNode(stackPane);
                                anim.setDuration(Duration.millis(300));
                                for (int k = i - 1; k >= 0; k--) {
                                    int finalK = k;
                                    if (lab.get(k).get(j).getText().equals("") && k != 0) continue;
                                    if (lab.get(k).get(j).getText().equals("") && k == 0) {
                                        anim.setByY(80 * (k - i));
                                        anim.play();
                                        lab.get(k).get(j).setText(lab.get(i).get(j).getText());
                                        lab.get(k).get(j).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalK).get(finalJ).setVisible(true);
                                            rec.get(finalK).get(finalJ).setFill(color);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(k).get(j).getText()) != Integer.parseInt(lab.get(i).
                                            get(j).getText())) {
                                        anim.setByY(80 * (k - i + 1));
                                        anim.play();
                                        lab.get(k + 1).get(j).setText(lab.get(i).get(j).getText());
                                        lab.get(k + 1).get(j).setVisible(false);
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        if (i - k != 1) {
                                            lab.get(i).get(j).setText("");
                                            rec.get(i).get(j).setFill(Color.WHITE);
                                        }
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            rec.get(finalK + 1).get(finalJ).setFill(color);
                                            lab.get(finalK + 1).get(finalJ).setVisible(true);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(k).get(j).getText()) == Integer.parseInt(lab.get(i).
                                            get(j).getText())) {
                                        anim.setByY(80 * (k - i));
                                        anim.play();
                                        int a = 2 * Integer.parseInt(lab.get(i).get(j).getText());
                                        lab.get(k).get(j).setText(Integer.toString(a));
                                        lab.get(k).get(j).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalK).get(finalJ).setVisible(true);
                                            setColor(lab.get(finalK).get(finalJ), rec.get(finalK).get(finalJ));
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    random2or4(lab, rec);
                    break;
                case DOWN:
                    for (int i = n - 2; i >= 0; i--) {
                        for (int j = 0; j < n; j++) {
                            int finalI = i;
                            int finalJ = j;
                            if (!lab.get(i).get(j).getText().equals("")) {
                                Rectangle copyRec = rec.get(finalI).get(finalJ);
                                Rectangle rectangle = new Rectangle(copyRec.getX(), copyRec.getY(), copyRec.
                                        getWidth(), copyRec.getHeight());
                                rectangle.setFill(copyRec.getFill());
                                rectangle.setStroke(Color.BLACK);
                                Label label = new Label(lab.get(finalI).get(finalJ).getText());
                                label.setLayoutX(15);
                                label.setLayoutY(10);
                                label.setStyle(lab.get(finalI).get(finalJ).getStyle());
                                StackPane stackPane = new StackPane(rectangle, label);
                                stackPane.setAlignment(Pos.CENTER);
                                stackPane.setLayoutX(rectangle.getX());
                                stackPane.setLayoutY(rectangle.getY());
                                group.getChildren().add(stackPane);
                                anim = new TranslateTransition();
                                anim.setNode(stackPane);
                                anim.setDuration(Duration.millis(300));
                                for (int k = finalI + 1; k < n; k++) {
                                    int finalK = k;
                                    if (lab.get(k).get(j).getText().equals("") && k != n - 1) continue;
                                    if (lab.get(k).get(j).getText().equals("") && k == n - 1) {
                                        anim.setByY(80 * (k - i));
                                        anim.play();
                                        lab.get(k).get(j).setText(lab.get(i).get(j).getText());
                                        lab.get(k).get(j).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalK).get(finalJ).setVisible(true);
                                            rec.get(finalK).get(finalJ).setFill(color);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) != Integer.parseInt(lab.get(k).
                                            get(j).getText())) {
                                        anim.setByY(80 * (k - i - 1));
                                        anim.play();
                                        lab.get(k - 1).get(j).setText(lab.get(i).get(j).getText());
                                        lab.get(k - 1).get(j).setVisible(false);
                                        Color color = (Color) rec.get(i).get(j).getFill();
                                        if (k - i != 1) {
                                            lab.get(i).get(j).setText("");
                                            rec.get(i).get(j).setFill(Color.WHITE);
                                        }
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            rec.get(finalK - 1).get(finalJ).setFill(color);
                                            lab.get(finalK - 1).get(finalJ).setVisible(true);
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                    if (Integer.parseInt(lab.get(i).get(j).getText()) == Integer.parseInt(lab.get(k).
                                            get(j).getText())) {
                                        anim.setByY(80 * (k - i));
                                        anim.play();
                                        int a = 2 * Integer.parseInt(lab.get(i).get(j).getText());
                                        lab.get(k).get(j).setText(Integer.toString(a));
                                        lab.get(k).get(j).setVisible(false);
                                        lab.get(i).get(j).setText("");
                                        rec.get(i).get(j).setFill(Color.WHITE);
                                        anim.setOnFinished(event1 -> {
                                            if (newRandomY >= 0 && newRandomY <= 3 && newRandomX >= 0 && newRandomX <= 3) {
                                                lab.get(newRandomY).get(newRandomX).setVisible(true);
                                                rec.get(newRandomY).get(newRandomX).setFill(Color.web("ffffc8"));
                                            }
                                            lab.get(finalK).get(finalJ).setVisible(true);
                                            setColor(lab.get(finalK).get(finalJ), rec.get(finalK).get(finalJ));
                                            group.getChildren().remove(stackPane);
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    random2or4(lab, rec);
                    break;
            }
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

    private void random2or4(ArrayList<ArrayList<Label>> lab, ArrayList<ArrayList<Rectangle>> rec) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lab.get(i).get(j).getText().equals("")) {
                    x.add(j);
                    y.add(i);
                }
            }
        }
        Random random = new Random();
        int first = random.nextInt(x.size());
        newRandomX = x.get(first);
        newRandomY = y.get(first);
        lab.get(y.get(first)).get(x.get(first)).setText("2");
        lab.get(y.get(first)).get(x.get(first)).setVisible(false);

    }
}

class Sleep extends Thread{
    TranslateTransition anim;
    private ArrayList<ArrayList<Label>> lab;
    private ArrayList<ArrayList<Rectangle>> rec;
    private int finalI;
    private int finalJ;
    private int k;

    Sleep (TranslateTransition anim, ArrayList<ArrayList<Label>> lab, ArrayList<ArrayList<Rectangle>> rec,
           int finalI, int finalJ, int k) {
        this.anim = anim;
        this.lab = lab;
        this.rec = rec;
        this.finalI = finalI;
        this.finalJ = finalJ;
        this.k = k;
    }

    public void run() {
        lab.get(finalI).get(k).setVisible(true);
        rec.get(finalI).get(k).setFill(rec.get(finalI).get(finalJ).getFill());
    }
}

class Player {
    String username;
    String password;
}
