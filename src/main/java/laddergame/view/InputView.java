package laddergame.view;

import laddergame.util.Util;

import java.util.Scanner;

public class InputView {
    public static final int MAX_NAME_LENGTH = 5;
    public static Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        String inputName = null;
        boolean isPass = false;

        while (!isPass) {
            System.out.println("참여할 사람 이름을 입력하세요. 최대5글자.(이름은 쉼표(,)로 구분하세요)");
            inputName = scanner.next();
            isPass = checkName(inputName);
        }
        return inputName;
    }

    public static boolean checkName(String input) {
        String[] names = input.split(Util.COMMA);
        for (String name : names) {
            if(!isOverNameLength(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOverNameLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static int getMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

    public static String getResult(int playerNum) {
        boolean isPass = false;
        String result = null;

        while(!isPass) {
            System.out.println("참여할 사람과 동일한 숫자의 실행 결과를 입력하세요.(결과는 쉼표(,)로 구분하세요)");
            result = scanner.next();
            isPass = checkResultCount(result, playerNum);
        }
        return result;
    }

    public static boolean checkResultCount(String input, int num) {
        String[] results = input.split(Util.COMMA);
        return results.length == num;
    }

    public static String getNameForTheResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
