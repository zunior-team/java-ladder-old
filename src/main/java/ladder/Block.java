package ladder;

import ladder.dto.BlockDto;
import ladder.init.InitInfo;
import ladder.strategy.PollCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Block {
    private final List<Point> points;

    public Block(InitInfo initInfo) {
        PollCreateStrategy createStrategy = initInfo.getPollCreateStrategy();
        points = new ArrayList<>();

        points.add(Point.start(createStrategy));
        IntStream.range(1, initInfo.getWidth() - 1)
                .mapToObj(i -> createNextPoint(createStrategy))
                .forEach(points::add);

        points.add(Point.end(points.get(points.size() - 1)));
    }

    public int takeLadder(int position) {
        return points.get(position)
                .move();
    }

    public List<Boolean> getPollInfos() {
        return points.stream()
                .map(Point::hasPoll)
                .collect(Collectors.toList());
    }

    private Point createNextPoint(PollCreateStrategy createStrategy) {
        return Point.of(points.get(points.size() - 1), createStrategy);
    }
}
