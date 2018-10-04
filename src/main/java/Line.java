import java.util.ArrayList;

public class Line {
    private static final int RANDOM_NUM = 10;
    private static final int POSSIBLE_MAKE_DASH = 5;
    private ArrayList<Boolean> points = new ArrayList<>();

    public ArrayList<Boolean> oneLine(int people) {
        for (int i = 0; i < people - 1; i++) {
            points.add(check(random()));
        }
        points.add(false);
        return points;
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }

    public boolean check(int num) {
        if (num > POSSIBLE_MAKE_DASH) {
            return false;
        }
        return true;
    }

    public int random() {
        int random;
        random = (int) (Math.random() * RANDOM_NUM);
        return random;
    }
}
