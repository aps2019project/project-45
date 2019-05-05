import controller.PlayController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        PlayController playController = new PlayController();
        //playController.firstToEnd();
        ArrayList<Integer> a = new ArrayList<>() , b = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            a.add(i);
        }
        b.addAll(a);
        System.out.println(Arrays.toString(b.toArray()));
    }


}
