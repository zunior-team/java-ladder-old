package laddergame;

import java.util.List;
import java.util.Scanner;

public class LadderMaker {

    static final String NONE = "     ";
    static final String HORIZONTAL = "-----";
    static final String VERTICAL = "|";

    static final int NAMELENLIMIT = 6;


    public static int inputNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String[] inputPeople() {
        Scanner sc = new Scanner(System.in);
        String people = sc.nextLine();
        return people.split(",");
    }

    public static int printPeopleLength(String[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.print(makeIndent(people[i]));
        }
        System.out.print("\n");
        return people.length;
    }

    public static String makeIndent(String name) {
        StringBuilder sb = new StringBuilder(name);
        int indentLen = NAMELENLIMIT - name.length();

        for (int i = 0; i < indentLen; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.println(drawLine(line.getLine()));
        }
    }

    public static String drawLine(List<Integer> line) {
        StringBuilder sb = new StringBuilder();

        for (int point : line) {
            sb.append(checkPoint(point));
        }
        return sb.toString();
    }

    public static String checkPoint(int point) {
        StringBuilder sb = new StringBuilder();

        switch (point) {
            case Line.HORIZONTAL:
                sb.append(HORIZONTAL);
                break;
            case Line.NONE:
                sb.append(NONE);
                break;
            case Line.VERTICAL:
                sb.append(VERTICAL);
                break;
            default:
                break;
        }
        return sb.toString();
    }
}
