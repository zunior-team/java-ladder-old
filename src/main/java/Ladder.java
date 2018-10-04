import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladders;

    public Ladder(int height) {
        ladders = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladders.add(new Line());
        }
    }

    public List<Line> getLadders() {
        return ladders;
    }

    public void makeLadders(int people, int height) {
        for (int i = 0; i < height; i++) {
            ladders.get(i).oneLine(people);
        }
//        System.out.println("ladders:::" + ladders.toString());
    }
}
