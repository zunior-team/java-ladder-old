package ladder.view;

import ladder.domain.Names;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    public static int ladderHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int row = scanner.nextInt();
        return row;
    }

    public static ArrayList<String> getNames(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String getNames = scanner.nextLine();
        Names forNames = new Names();
        ArrayList<String> splitNames = forNames.getSplitNames(getNames);
        return Names.checkNames(splitNames);
    }
}
