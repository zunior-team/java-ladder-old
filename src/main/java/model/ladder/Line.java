package model.ladder;

import exception.LadderResultCreateException;
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
        line.createStartBarByPlayers((players.getPlayerCount() - 1), START_POINT);
        return line;
    }

    private void createStartBarByPlayers(final int totalPoint, final int currentPoint){
        points.add(new Point(PointState.BAR, currentPoint));

        if(totalPoint == currentPoint){
            return;
        }

        PointState currentPointState = Point.generateStateByRandom();

        if(isBeforeLine()){
            currentPointState = PointState.SPACE;
        }

        createIntervalByPoint(currentPointState);
        createStartBarByPlayers(totalPoint, (currentPoint + 1));
    }


    private void createIntervalByPoint(PointState state){
        IntStream.rangeClosed(1, DEFAULT_INTERVAL)
                .forEach(i -> points.add(new Point(state)));
    }

    private boolean isBeforeLine(){
        if(points.size() == 1){
            return false;
        }

        return points.get(points.size() - 2)
                .isDash();
    }

    public List<String> toDisplays(){
        return points.stream()
                .map(Point::getDisplay)
                .collect(Collectors.toList());
    }

    private int leftOnePosition(int currentPos){ return currentPos - 1; }
    private boolean isMovableLeft(int currentPos){ return (currentPos - 1 >= 0); }
    private int rightOnePosition(int currentPos){ return currentPos + 1; }
    private boolean isMovableRight(int currentPos){ return (currentPos + 1 < points.size()); }

    public int getPosition(int colIndex){
        if(isMovableLeft(colIndex) && points.get(leftOnePosition(colIndex)).isDash()){
            return moveSideIfPossibleElseNot(colIndex - 1, -1);
        }
        if(isMovableRight(colIndex) && points.get(rightOnePosition(colIndex)).isDash()){
            return moveSideIfPossibleElseNot(colIndex + 1, 1);
        }
        return colIndex;
    }

    private int moveSideIfPossibleElseNot(int colIndex, int movingValue){
        if(isMovableLeft(colIndex) && isMovableRight(colIndex)){
            return moveSideIfPossibleElseNot(colIndex + movingValue, movingValue);
        }

        return colIndex;
    }

    public int convertPlayerIndexToPosition(int playerIndex) {
        return (playerIndex * DEFAULT_INTERVAL);
    }

    public int convertPositionToPlayerIndex(int position) {
        return (position / DEFAULT_INTERVAL);
    }
}
