package ladder.console;

import ladder.UserAndPrize;
import ladder.init.InitInfo;
import ladder.init.LadderInitInfo;
import ladder.prize.Prizes;
import ladder.strategy.Complexity;
import ladder.strategy.ComplexityPollCreateStrategy;
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
        showInputComplexity();
        Complexity complexity = Complexity.of(getComplexity());

        return new InitInfo(new LadderInitInfo(complexity.getHeight(), userAndPrize.width()),
                new ComplexityPollCreateStrategy(complexity)
        );
    }

    private static List<String> getPrizes() {
        return getLineAndSplit();
    }

    private static void showInputPrize() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
    }

    private static void showInputComplexity() {
        System.out.println("실행할 사다리의 난이도는?");
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


    private static String getComplexity() {
        return SCANNER.nextLine()
                .trim();
    }

    public static String getTargetToShowResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
