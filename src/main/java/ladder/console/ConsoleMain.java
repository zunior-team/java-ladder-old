package ladder.console;

import ladder.Ladder;
import ladder.UserAndPrize;
import ladder.dto.LadderResult;

public class ConsoleMain {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        UserAndPrize usersAndPrizes = ConsoleInput.getUsersAndPrizes();
        Ladder ladder = new Ladder(ConsoleInput.getInitInfo(usersAndPrizes));

        //draw : userAndPrize, Ladder
        ConsoleOutput.drawLadder(usersAndPrizes, ladder);


        //draw result stringStringMap;
        LadderResult ladderResult = ladder.takeLadders(usersAndPrizes);
        String target;
        while(!(target = ConsoleInput.getTargetToShowResult()).equalsIgnoreCase(EXIT)) {
            ConsoleOutput.showTargetPrize(ladderResult, target);
        }
    }
}
