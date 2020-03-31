package model.ladder;

import java.util.List;

public class Line {

    private List<Point> points;

    public Line(){

    }

    public static Line of(int currentHeight) {
        return new Line();
    }
}
