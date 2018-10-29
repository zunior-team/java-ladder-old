package ladder.view;

import ladder.domain.Ladder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultView {
    private static final String LADDER_HEIGHT = "|";
    private static final String LINK = "-----";
    private static final String BLANK = "     ";

    public static void nameOutput(String[] name) {
        for (int i = 0; i < name.length; i++) {
            System.out.print(String.format("%-6s", name[i]));
        }
        System.out.println();
    }

    public static void transverse(ArrayList<Ladder> user, String[] name) {
        for (int i = 0; i < user.size(); i++) {
            repeatOutput(user.get(i).getValue());
        }
    }

    private static void repeatOutput(ArrayList<Boolean> user) {
        for (int j = 0; j < user.size(); j++) {
            String inputBlank = BLANK;
            System.out.print(LADDER_HEIGHT);
            inputBlank = Process(user, j, inputBlank);
            System.out.print(inputBlank);
        }
        System.out.println(LADDER_HEIGHT);
    }

    private static String Process(ArrayList<Boolean> user, int j, String inputBlank) {
        if (user.get(j) == true) {
            inputBlank = LINK;
        }
        return inputBlank;
    }
}
