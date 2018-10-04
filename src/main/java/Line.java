import java.util.ArrayList;

public class Line {
    private final int RANDOM_NUM = 10;
    private final int POSSIBLE_MAKE_DASH = 5;
    public static int barPosition = 1;
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line() {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    public ArrayList<Boolean> oneLine(int people) {
        for (int i = 0; i < people - 1; i++) {
            points.add(check(random()));
        }
        points.add(false);
//        System.out.println(this.points);
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
