package ladder.console;

import ladder.init.InitInfo;
import ladder.init.LadderInitInfo;
import ladder.strategy.RandomPollCreateStrategy;
import ladder.user.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLITTER = ",";

    public static InitInfo getInitInfo() {
        showInputParticipantsStatement();
        Users users = new Users(getParticipants());

        showInputHeightOfLadder();
        int height = getHeightOfLadder();

        return new InitInfo(users, new LadderInitInfo(height, new RandomPollCreateStrategy()));
    }

    private static void showInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    private static void showInputParticipantsStatement() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static List<String> getParticipants() {
        String[] split = SCANNER.nextLine()
                .trim()
                .split(SPLITTER);

        return Arrays.asList(split);
    }

    private static int getHeightOfLadder() {
        return Integer.parseInt(SCANNER.nextLine().trim());
    }
}
