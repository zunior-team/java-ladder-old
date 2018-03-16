package codesquad;

import java.util.ArrayList;
import java.util.List;

import static codesquad.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = null;
        for (int i = 0; i < sizeOfPerson; i++) {
            if (i == 0) {
                point = Point.first(generatePoint());
                points.add(point);
                continue;
            }

            point = point.next();
            points.add(point);
        }
        return new LadderLine(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
