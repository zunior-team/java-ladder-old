package ladder;

import ladder.strategy.PollCreateStrategy;

public class Point {
    private final int index;
    private final Poll poll;

    public int move() {
        return poll.move(index);
    }

    private Point(int index, PollCreateStrategy pollCreateStrategy) {
        this.index = index;
        this.poll = Poll.NONE.nextPoll(pollCreateStrategy);
    }

    private Point(Point prevPoint, PollCreateStrategy pollCreateStrategy) {
        this.index = prevPoint.index + 1;
        this.poll = prevPoint.poll.nextPoll(pollCreateStrategy);
    }

    public static Point start(PollCreateStrategy pollCreateStrategy) {

        return new Point(0, pollCreateStrategy);
    }

    public static Point of(Point prevPoint, PollCreateStrategy pollCreateStrategy) {

        return new Point(prevPoint, pollCreateStrategy);
    }

    public static Point end(Point prevPoint) {

        return new Point(prevPoint, () -> false);
    }

    public boolean hasPoll() {
        return poll.hasPoll();
    }
}
