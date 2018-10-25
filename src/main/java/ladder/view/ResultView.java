package ladder.view;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultView {
    private static final String LADDER_HEIGHT = "|";
    private static final String LINK = "-";
    private static final String BLANK = " ";

    public void transverse(ArrayList<ArrayList<Boolean>> user) {
        for (int i = 0; i < user.size(); i++) {
            repeatOutput(user, i);
            System.out.println(LADDER_HEIGHT);
        }
    }

    private void repeatOutput(ArrayList<ArrayList<Boolean>> user, int i) {
        for (int j = 0; j < user.get(i).size(); j++) {
            String inputBlank = BLANK;
            System.out.print(LADDER_HEIGHT);
            inputBlank = Process(user.get(i), j, inputBlank);
            System.out.print(inputBlank);
        }
    }

    private String Process(ArrayList<Boolean> user, int j, String inputBlank) {
        if (user.get(j) == true) {
            inputBlank = LINK;
        }
        return inputBlank;
    }
}
