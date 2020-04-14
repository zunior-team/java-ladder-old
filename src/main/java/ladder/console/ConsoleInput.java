package ladder.console;

import ladder.UserAndPrize;
import ladder.init.InitInfo;
import ladder.init.LadderInitInfo;
import ladder.prize.Prizes;
import ladder.strategy.RandomPollCreateStrategy;
import ladder.user.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLITTER = ",";

    public static UserAndPrize getUsersAndPrizes() {
        showInputParticipantsStatement();
        Users users = new Users(getParticipants());

        showInputPrize();
        Prizes prizes = new Prizes(getPrizes());

        return new UserAndPrize(users, prizes);

    }

    public static InitInfo getInitInfo(UserAndPrize userAndPrize) {
        showInputHeightOfLadder();
        int height = getHeightOfLadder();

        return new InitInfo(new LadderInitInfo(height, userAndPrize.width()), new RandomPollCreateStrategy());
    }

    private static List<String> getPrizes() {
        return getLineAndSplit();
    }

    private static void showInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    private static void showInputPrize() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
    }

    private static void showInputParticipantsStatement() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static List<String> getParticipants() {
        return getLineAndSplit();
    }

    private static List<String> getLineAndSplit() {
        String[] split = SCANNER.nextLine()
                .trim()
                .split(SPLITTER);

        return Arrays.asList(split);
    }


    private static int getHeightOfLadder() {
        return Integer.parseInt(SCANNER.nextLine().trim());
    }
}
