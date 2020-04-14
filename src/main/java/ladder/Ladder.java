package ladder;

import ladder.init.InitInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int width;
    private final List<Block> blocks;

    public Ladder(InitInfo initInfo) {
        this.width = initInfo.numOfUsers();
        this.blocks = IntStream.rangeClosed(0, initInfo.getHeight())
                .mapToObj(i -> new Block(initInfo))
                .collect(Collectors.toList());
    }

    public List<Integer> takeLadders() {
        return IntStream.rangeClosed(0, width)
                .map(this::takeLadder)
                .boxed()
                .collect(Collectors.toList());
    }

    public int takeLadder(int startPosition) {
        return blocks.stream()
                .reduce(startPosition, (byPosition, block) -> block.takeLadder(byPosition),
                        (x, y) -> {throw new RuntimeException("Parallel operation is not allowed at this logic");}
                );
    }
}
