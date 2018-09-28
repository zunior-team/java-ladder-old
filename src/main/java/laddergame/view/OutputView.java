package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.dto.LadderGameDto;

import java.util.List;
import java.util.Scanner;

public class OutputView {
    private static final String FORMAT = "%-6s";
    private static final String DASH = "-----";
    private static final String BLANK = "     ";
    private static final String VERTICAL_BAR = "|";
    private static Scanner sc = new Scanner(System.in);

    public static void printResult(LadderGameDto dto) {
        print(dto.getNames());
        printLadder(dto.getLadder());
        print(dto.getResults());
    }

    private static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            printLine(ladder.getLine(i));
        }
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_BAR);
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i) ? DASH : BLANK);
            sb.append(VERTICAL_BAR);
        }
        System.out.println(sb.toString());
    }

    private static void print(List<String> values) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(String.format(FORMAT, value));
        }
        System.out.println(sb.toString());
    }

    public static void checkResult(List<String> finalNamePosition, List<String> result) {
        while(true){
            System.out.println("결과를 보고 싶은 사람은?");
            String input = sc.nextLine();
            System.out.println("실행 결과");
            if (input.equals("all")) {
                break;
            }
            System.out.println(result.get(finalNamePosition.indexOf(input)));
        }
        printAll(finalNamePosition, result);
    }

    private static void printAll(List<String> finalNamePosition, List<String> result) {
        for (int i = 0; i < finalNamePosition.size(); i++) {
            System.out.println(result.get(i) + " : " + finalNamePosition.get(i));
        }
    }
}
