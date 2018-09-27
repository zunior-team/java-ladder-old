package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final int NAMELENLIMIT = 5;
    public static final int ALL = -1;

    public static int inputNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String inputStr() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String[] inputTexts() {
        Scanner sc = new Scanner(System.in);
        String people = sc.nextLine();
        return people.split(",");
    }

    public static String[] checkText() {
        String[] people = inputTexts();
        for (String name : people) {
            checkTextLen(name);
        }
        return people;
    }

    public static void checkTextLen(String name) {
        if (name.length() > NAMELENLIMIT) {
            throw new IllegalArgumentException("각 Text의 길이는 5 이상일 수 없습니다.");
        }
    }

    public static int checkResultIdx(String[] people) {
        String name = inputStr();
        if (name.equals("all")) {
            return ALL;
        }
        return searchResultIdx(name, people);
    }

    public static int searchResultIdx(String name, String[] people) {
        List<String> names = Arrays.asList(people);

        if (!names.contains(name)) {
            throw new IllegalArgumentException("없는 name을 입력하셨습니다.");
        }
        return names.indexOf(name);
    }

}