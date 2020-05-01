package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.constant.LadderConstants.*;

public class Line {

    private List<Boolean> points;

    private Line(List<Boolean> points){
        this.points = points;
    }

    public static Line of(int width,int percentage){
        validateWidth(width);

        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            boolean randomPoint = PointCreator.createRandomPointByPercentage(percentage);
            boolean continues = checkContinues(i, points, randomPoint);
            randomPoint = !continues && randomPoint;
            points.add(randomPoint);
        }
        return new Line(points);
    }
    public boolean hasBridge(int position){
        return points.get(position);
    }

    private static boolean checkContinues(int index,List<Boolean> points,boolean randomPoint){
        return (index>0 && points.get(index-1) && randomPoint);
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
        return points.toString();
    }
}
