package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private ArrayList<Boolean> points;

    public Line(int countOfFoothold) {
        points = new ArrayList<>();
        points.add(MyRandom.get());
        for (int i = 1; i < countOfFoothold; i++) {
            boolean prevFoothold = points.get(i - 1);
            points.add(!prevFoothold && MyRandom.get());
        }
    }

    public List<Boolean> getPoints(){
        return this.points;
    }



}

