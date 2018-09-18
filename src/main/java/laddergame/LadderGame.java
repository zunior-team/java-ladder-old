package laddergame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        int person = inputPeple();
        int height = inputHeight();
        ArrayList<ArrayList<Boolean>> ladders = getHeight(person, height);
        displayLadder(ladders);
    }

    public static int inputPeple() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명 인가요?");
        return scanner.nextInt();
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
        }

    public static boolean isTrue() {
        Random random = new Random();
        int randomDraw = random.nextInt(10);
        return randomDraw >= 5;
    }

    public static String lineOrBlank(boolean isTrue) {
        String line = " ";
        if(isTrue) {
            line = "-";
        }
        return line;
    }

    public static void displayLadder(ArrayList<ArrayList<Boolean>> ladders) {
        for (ArrayList<Boolean> ladder : ladders) {
            toStringLadder(ladder);
        }
    }
    public static void toStringLadder(ArrayList<Boolean> isLadder) {
        String ladder = "";
        for (Boolean aBoolean : isLadder) {
            ladder += "l";
            ladder += lineOrBlank(aBoolean);
        }
        ladder += "l";
        System.out.println(ladder);
    }

    // l- 를 동시에 출력하다가 마지막만 l 출력
    public static ArrayList<Boolean> getOneLine(int person) {
        ArrayList<Boolean> ladder = new ArrayList<>();

        for (int i = 0; i < person-1; i++) {
            ladder.add(isTrue());
        }
        return ladder;
    }

    public static ArrayList<ArrayList<Boolean>> getHeight(int person, int height) {
        ArrayList<ArrayList<Boolean>> ladders = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladders.add(getOneLine(person));
        }
        return ladders;
    }

}
