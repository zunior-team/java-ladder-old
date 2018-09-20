package laddergame.view;

import java.util.Scanner;

public class InputView {

    public static final int NAMELENLIMIT = 5;

    public static int inputNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String[] inputPeople() {
        Scanner sc = new Scanner(System.in);
        String people = sc.nextLine();
        return people.split(",");
    }

    public static String[] checkPeople() {
        String[] people = inputPeople();
        for (String name : people) {
            checkNameLen(name);
        }
        return people;
    }

    public static void checkNameLen(String name) {
        if (name.length() > NAMELENLIMIT) {
            throw new IllegalArgumentException("gamer 이름은 5글자를 넘을 수 없습니다.");
        }
    }

}