package laddergame.view;

import java.util.Scanner;

public class InputView {
    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 누구 인가요?");
        return scanner.nextLine();
    }

    public static String getResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("결과 값을 입력해 주세요");
        return scanner.nextLine();
    }

    public static int getLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

    public static String getNameResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("결과를 알고 싶은게 무엇인가요?('all' 을 입력하면 전부 출력후 종료)");
        return scanner.nextLine();
    }
}
