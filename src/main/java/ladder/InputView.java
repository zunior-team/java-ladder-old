package ladder;

import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);
    private static final int LIMIT_NUMBER = 5;
    private static final String DIVISION = ",";

    public static String inputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scan.next();
    }

    public static String inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scan.next();
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scan.nextInt();
    }

    public static String choicePerson() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scan.next();
    }

    public static String[] nameCheck(String inputName) {
        String[] names = valueSplit(inputName);
        if (names.length == 1) {
            PrintView.noPlay();
            names = nameCheck(inputName());
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > LIMIT_NUMBER || names[i].trim().isEmpty()) {
                PrintView.reWrite();
                names = nameCheck(inputName());
                break;
            }
        }
        return names;
    }

    public static String[] resultLengthCheck(String[] names, String inputResult) {
        String[] gameResult = valueSplit(inputResult);
        if (names.length != gameResult.length) {
            PrintView.notLengthMatch();
            gameResult = resultLengthCheck(names, InputView.inputResult());
        }
        return gameResult;
    }

    public static String[] valueSplit(String value) {
        String[] values = value.split(DIVISION);
        return values;
    }
}
