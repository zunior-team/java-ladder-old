package ladder.domain;

public class NameAndRewardLengthCheck {

    public static boolean checkLengthOfNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static String[] checkNames(String[] names) {
        if (!checkLengthOfNames(names)) {
            throw new RuntimeException();
        }
        return names;
    }
}
