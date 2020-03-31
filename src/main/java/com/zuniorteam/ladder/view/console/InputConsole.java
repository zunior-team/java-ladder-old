package com.zuniorteam.ladder.view.console;

import java.util.Scanner;

public class InputConsole {

    private final Scanner SCANNER = new Scanner(System.in);

    public String getUsernames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return SCANNER.nextLine();
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        final int height = SCANNER.nextInt();
        SCANNER.nextLine();

        return height;
    }
}
