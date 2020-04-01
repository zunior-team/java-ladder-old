package ladder;

import ladder.init.InitInfo;
import ladder.strategy.PollCreateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Block {
    private List<Boolean> polls;

    public Block(InitInfo initInfo) {
        PollCreateStrategy createStrategy = initInfo.getPollCreateStrategy();

        polls = IntStream.rangeClosed(0, initInfo.numOfUsers())
                .mapToObj(i -> createStrategy.decideCreateOrNot())
                .collect(Collectors.toList());

        refinePolls();
    }

    /* 연속으로 true 가 나오는 것을 방지하기 위한 정제 함수 */
    private void refinePolls() {
        IntStream.range(1, polls.size())
                .forEach(i -> polls.set(i, polls.get(i - 1) ? false : polls.get(i)));
    }

    public boolean hasLadder(int idx) {
        return hasRightLadder(idx) || hasLeftLadder(idx);
    }

    public boolean hasRightLadder(int idx) {
        if(idx >= polls.size() - 1) {
            return false;
        }

        return polls.get(idx);
    }

    public boolean hasLeftLadder(int idx) {
        if(idx < 1) {
            return false;
        }

        return polls.get(idx - 1);
    }
}
