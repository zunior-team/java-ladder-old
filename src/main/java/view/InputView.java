package view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String[] humans() {
        System.out.println("이름을 적어주세요.(이름을 나눌 때 ','를 사용해주시며, 5글자 이하로 적어주세요.)");
        String[] name = scanner.next().split(",");
        while (namesNum(name)) {
            System.out.println("다시 입력해주세요.");
            name = scanner.next().split(",");
        }
        return name;
    }

    public static boolean namesNum(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                return true;
            }
        }
        return false;
    }

    public static int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String[] result(String[] names) {
        System.out.println("결과 값을 입력해주세요.");
        String[] result = scanner.next().split(",");
        while (resultNum(names, result)) {
            System.out.println("이름 값과 똑같은 갯수 만큼 만들어주세요.");
            result = scanner.next().split(",");
        }
        return result;
    }

    public static boolean resultNum(String[] names, String[] result) {
        for (int i = 0; i < names.length; i++) {
            if (result.length == i && result[i].length() > 5) {
                return true;
            }
        }
        return false;
    }

    public static String showResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String userResult = scanner.next();
        return userResult;
    }

}
