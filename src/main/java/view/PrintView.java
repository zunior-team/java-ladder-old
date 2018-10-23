package view;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import ladder.Ladder;
import ladder.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintView {
    static StringBuilder stringBuilder = new StringBuilder();
    //결과값들과 이름들은 많은 메소드에서 사용하기 때문에 전역변수로 만들어 매개변수를 줄일수가 있다.
    private static List<String> results;
    private static List<String> names;

    public static void totalPrint(Ladder ladder, String[] name) {
        names = ladder.getPeople();
        String[] result = InputView.result(name);
        String showResult = InputView.showResult();
        results = Arrays.asList(result);
        List<Line> ladders = ladder.getLadders();
        HashMap<Integer, Integer> resultHash = ladder.moveLine();
        printResult(ladders);
        checkResult(resultHash, showResult);
        System.out.println(String.valueOf(stringBuilder));
    }

    public static void printResult(List<Line> ladders) {
        for (int i = 0; i < names.size(); i++) {
            stringBuilder.append(String.format("%6s", names.get(i)));
        }
        stringBuilder.append("\n");
        for (int i = 0; i < ladders.size(); i++) {
            insidePrintResult(ladders, i);
            stringBuilder.append("\n");
        }

        for (int i = 0; i < results.size(); i++) {
            stringBuilder.append(String.format("%6s", results.get(i)));
        }
        stringBuilder.append("\n");
    }

    private static void insidePrintResult(List<Line> ladders, int i) {
        stringBuilder.append("     ");
        for (int j = 0; j < names.size(); j++) {
            printBar();
            stringBuilder.append(printDash(ladders, i, j));
        }
    }

    public static void printBar() {
        stringBuilder.append("|");
    }

    private static String printDash(List<Line> ladders, int i, int j) {
        if (ladders.get(i).getPoints().get(j)) {
            return "-----";
        }
        return "     ";
    }

    public static void checkResult(HashMap<Integer, Integer> hashMap, String resultShow) {
        if (resultShow.equals("all")) {
            for (int i = 0; i < results.size(); i++) {
                stringBuilder.append(names.get(i) + " : " + results.get(hashMap.get(i)));
                stringBuilder.append("\n");
            }
        }
        for (int i = 0; i < results.size(); i++) {
            if (resultShow.equals(names.get(i))) {
                stringBuilder.append(results.get(hashMap.get(i)));
            }
        }
    }
}