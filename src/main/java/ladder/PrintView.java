package ladder;

import java.util.*;

public class PrintView {
    private static final String VERTICAL = "|";
    private static final String DASH = "-----";
    private static final String VERTICAL_WIDTH = "     "; // 5칸
    private static final String BLANK = " ";              // 1칸

    public static void valuePrint(String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.print(BLANK);
            blankCount(i, names);
            System.out.print(names[i]);
        }
        System.out.println();
    }

    private static void blankCount(int i, String[] names) {
        for (int j = names[i].length(); j < VERTICAL_WIDTH.length(); j++) {
            System.out.print(BLANK);
        }
    }

    public static void ladderPrint(ArrayList<Line> allLine) {
        for (int i = 0; i < allLine.size(); i++) {
            valuePrint(allLine.get(i));
            System.out.println();
        }
    }

    private static void valuePrint(Line line) {
        System.out.print(VERTICAL_WIDTH);
        for (Boolean bool : line.getPoints()) {
            System.out.print(VERTICAL);
            System.out.print(bool ? DASH : VERTICAL_WIDTH);
        }
    }

    public static void reWrite() {
        System.out.println("이름이 없거나 다섯글자를 초과하였습니다.");
    }

    public static void notLengthMatch() {
        System.out.println("인원수와 일치하지 않습니다.");
    }

    public static void isName(Map<String, String> nameAndValue, String name) {
        System.out.println("실행 결과");
        if (nameAndValue.containsKey(name)) {
            String resultValue = nameAndValue.get(name);
            System.out.println(resultValue);
            isName(nameAndValue, InputView.choicePerson());
            // all을 입력할때까지 게임 결과를 물어본다.
        }
        if (!name.equals("all") && !nameAndValue.containsKey(name)) {
            isName(nameAndValue, InputView.choicePerson());

        }
        if (name.equals("all"))
            allPrint(nameAndValue);                                            // 결과를 보고 싶은 사람이 없을 경우 다시 물어본다.
    }

    private static void allPrint(Map<String, String> nameAndValue) {
        Set<String> nameMember = nameAndValue.keySet();
        Iterator<String> names = nameMember.iterator();
        while (names.hasNext()) {
            String name = names.next();
            System.out.println(name + ":" + nameAndValue.get(name));
        }
    }

    public static void noPlay() {
        System.out.println("혼자서는 플레이 할 수 없습니다.");
    }
}
