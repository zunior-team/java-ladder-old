package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Names {

    private static ArrayList<String> splitNames;

    public ArrayList<String> getSplitNames(String names) {
        ArrayList<String> splitName = new ArrayList<>(Arrays.asList(names.split(",")));
        return this.splitNames = splitName;
    }

    public static boolean checkLengthOfNames(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() > 5) {
                System.out.println("이름은 5글자 내로 정해주세요.");
                System.out.println("프로그램을 다시 실행해 주세요.");
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String> checkNames(ArrayList<String> names) {
        if (!checkLengthOfNames(names)) {
            throw new RuntimeException();
        }
        return names;
    }

}
