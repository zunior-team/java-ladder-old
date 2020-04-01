package ladder.console;

import ladder.Ladder;
import ladder.dto.LadderResult;
import ladder.init.InitInfo;

public class ConsoleMain {
    public static void main(String[] args) {
        InitInfo initInfo = ConsoleInput.getInitInfo();

        Ladder ladder = new Ladder(initInfo);
        LadderResult result = ladder.getResult();

        ConsoleOutput.drawResult(result);
    }
}
