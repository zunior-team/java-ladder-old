package model.ladder;

import model.player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int START_POINT = 0;
    private static final int DEFAULT_INTERVAL = 5;
    private List<Point> points = new ArrayList<>();

    public static Line of(Players players) {
        final Line line = new Line();
        line.createLineByPlayers((players.getPlayerCount() - 1), START_POINT);
        return line;
    }

    private void createLineByPlayers(final int totalPoint, final int currentPoint){
        points.add(new Point(PointState.BAR));

        if(totalPoint == currentPoint){
            return;
        }

        PointState currentPointState = Point.generateStateByRandom();

        if(isBeforeLine()){
            currentPointState = PointState.SPACE;
        }

        createIntervalByPoint(currentPointState);
        createLineByPlayers(totalPoint, (currentPoint + 1));
    }


    private void createIntervalByPoint(PointState state){
        IntStream.rangeClosed(1, DEFAULT_INTERVAL)
                .forEach(i -> points.add(new Point(state)));
    }

    public List<String> toDisplays(){
        return points.stream()
                .map(Point::getDisplay)
                .collect(Collectors.toList());
    }

    private boolean isBeforeLine(){
        if(points.size() == 1){
            return false;
        }

        return points.get(points.size() - 2)
                .isDash();
    }
}
