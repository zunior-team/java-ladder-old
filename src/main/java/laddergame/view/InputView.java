package laddergame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String REGEX = ",";
    private static Scanner sc = new Scanner(System.in);

    public static List<String> getInputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return arrayToList(nextSplitLine());
    }

    public static List<String> getInputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return arrayToList(nextSplitLine());
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    private static String[] nextSplitLine() {
        return sc.nextLine().split(REGEX);
    }

    private static List<String> arrayToList(String[] values) {
        List<String> ret = new ArrayList<>(Arrays.asList(values));
        return ret;
    }
}
