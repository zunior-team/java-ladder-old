package laddergame;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        String names = null;
        boolean isPass = false;

        while(isPass == false) {
            System.out.println("참여할 사람 이름을 입력하세요. 최대5글자.(이름은 쉼표(,)로 구분하세요)");
            names = scanner.next();
            isPass = checkName(names);
        }
        return names;
    }

    public static int getMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

    public static boolean checkName(String input) {
        boolean result = true;

        String[] names = input.split(",");
        for (String name : names) {
            result = checkNameLength(result, name);
        }
        return result;
    }

    private static boolean checkNameLength(boolean result, String name) {
        if(name.length() > 5) {
            result = false;
        }
        return result;
    }
}
