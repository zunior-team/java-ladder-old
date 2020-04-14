package ladder.console;

import ladder.Ladder;
import ladder.UserAndPrize;
import ladder.init.InitInfo;

import java.util.Map;

public class ConsoleMain {
    public static void main(String[] args) {
        UserAndPrize usersAndPrizes = ConsoleInput.getUsersAndPrizes();

        InitInfo initInfo = ConsoleInput.getInitInfo(usersAndPrizes);

        Ladder ladder = new Ladder(initInfo);
        //draw : userAndPrize, Ladder

        Map<String, String> stringStringMap = usersAndPrizes.matchUserAndPrize(ladder);
        //draw result stringStringMap;
    }
}
