import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int humans() {
        System.out.println("참여할 사람은 몇 명 인가요?");
        return scanner.nextInt();
    }

    public static int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
