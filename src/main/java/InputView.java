import java.util.Scanner;

public class InputView {
    public static int playerNum(Scanner scanner) {
        System.out.println("참여할 사람은 몇 명 인가요?");
        int column = scanner.nextInt() * 2 - 1;
        return column;
    }

    public static int ladderHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int row = scanner.nextInt();
        return row;
    }
}
