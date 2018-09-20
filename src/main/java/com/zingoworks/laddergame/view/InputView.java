package com.zingoworks.laddergame.view;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int inputPeople () {
        System.out.println("참여할 사람은 몇 명 인가요?");
        return sc.nextInt();
    }

    public static int inputMaxLadder () {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
