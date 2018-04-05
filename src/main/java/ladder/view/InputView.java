package ladder.view;

import ladder.domain.LadderSetting;
import ladder.domain.NameAndRewardLengthCheck;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int ladderHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int row = scanner.nextInt();
        return row;
    }

    public static String[] getNames(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] getNames = scanner.nextLine().split(",");
        return NameAndRewardLengthCheck.checkNames(getNames);
    }

    public static String[] getRewards(Scanner scanner) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        String[] getRewards = scanner.nextLine().split(",");
        return NameAndRewardLengthCheck.checkNames(getRewards);
    }

    private static String getTarget() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.next();
    }

    public static void iterateGetTarget(LadderSetting ladderGame) {
        while (true) {
            String name = getTarget();
            if (name.equals("all")) {
                OutputView.printTarget(ladderGame.play(name));
                break;
            }
            OutputView.printTarget(ladderGame.play(name));
            continue;
        }
    }
}
