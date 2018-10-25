package ladder.view;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultView {
   // static final String

    public void transverse(ArrayList<ArrayList<Boolean>> user) {
        for (int i = 0; i < user.size(); i++) {
            repeatOutput(user, i);
            System.out.println("|");
        }
    }

    private void repeatOutput(ArrayList<ArrayList<Boolean>> user, int i) {
        for (int j = 0; j < user.get(i).size(); j++) {
            System.out.print("|");
            if (user.get(i).get(j) == true) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }
        }
    }


}
