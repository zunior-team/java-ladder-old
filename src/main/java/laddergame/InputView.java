package laddergame;

import java.util.Scanner;

public class InputView {
    public static int getPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명 인가요?");
        return scanner.nextInt();
    }

    public static int getHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

}
