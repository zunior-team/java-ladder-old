package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.constant.LadderConstants.LADDER_LINE_MIN_WIDTH;

public class Line {

    private List<Boolean> points;

    private Line(List<Boolean> points){
        this.points = points;
    }

    public static Line of(int width){
        validateWidth(width);

        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            boolean randomPoint = PointCreator.createRandomPoint();
            randomPoint = checkContinuous(i,points.get(i-1),randomPoint);
            points.add(randomPoint);
        }
        return new Line(points);
    }
    private static boolean checkContinuous(int index,boolean previousPoint,boolean randomPoint){
        return index > 0 && previousPoint && randomPoint;
    }
    private static void validateWidth(int width){
        if(width < LADDER_LINE_MIN_WIDTH){
            throw new IllegalArgumentException("라인의 길이는"+LADDER_LINE_MIN_WIDTH+"를 초과해야 합니다.");
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
