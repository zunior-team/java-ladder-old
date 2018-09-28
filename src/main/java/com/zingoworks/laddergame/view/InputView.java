package com.zingoworks.laddergame.view;

import com.zingoworks.laddergame.utilities.Utilities;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    static final String COMMA = ",";

    static Scanner sc = new Scanner(System.in);

    public static ArrayList<StringBuilder> inputUser() {
        String[] str;
        ArrayList<StringBuilder> user = new ArrayList<>();

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        str = sc.nextLine().split(COMMA);

        return Utilities.checkLengthLimit(Utilities.convertToMutable(str, user));
    }

    public static ArrayList<StringBuilder> inputResult () {
        String[] str;
        ArrayList<StringBuilder> result = new ArrayList<>();

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        str = sc.nextLine().split(COMMA);

        return Utilities.convertToMutable(str, result);
    }

    public static int inputLadderHeight () {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public  static String inputUserToCheck() {
        System.out.println("결과를 보고 싶은 사람은?");
        return new String(sc.next());
    }
}