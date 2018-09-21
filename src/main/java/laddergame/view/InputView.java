package laddergame.view;

import java.util.Scanner;

public class InputView {
    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 누구 인가요?");
        return scanner.nextLine();
    }

    public static int getLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

}
