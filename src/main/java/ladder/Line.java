package ladder;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int move(int position) {
        Position p = new Position(position, points.size());
        if (p.isFirst()) {
            return moveCurrentPosition(p).getPosition();
        }

        Position previous = p.movePrevious();
        if (isMove(previous)) {
            return previous.getPosition();
        }

        return moveCurrentPosition(p).getPosition();
    }

    private boolean isMove(Position position) {
        return points.get(position.getPosition());
    }

    private Position moveCurrentPosition(Position position) {
        if (isMove(position)) {
            return position.moveNext();
        }
        return position;
    }
}
