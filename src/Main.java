import controller.PlayController;
import model.PlayingMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        PlayController playController = new PlayController();
        playController.firstToEnd();
    }
}
