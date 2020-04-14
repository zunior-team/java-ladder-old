package ladder;

import ladder.init.InitInfo;
import ladder.strategy.PollCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private final List<Point> points;

    public Block(InitInfo initInfo) {
        PollCreateStrategy createStrategy = initInfo.getPollCreateStrategy();

        points = new ArrayList<>();
    }

    public int takeLadder(int position) {
        return points.get(position)
                .move();
    }








/*
    public boolean hasLadder(int idx) {
        return hasRightLadder(idx) || hasLeftLadder(idx);
    }

    public boolean hasRightLadder(int idx) {
        if(idx >= polls.size() || idx < 0) {
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

    */
/* 연속으로 true 가 나오는 것을 방지하기 위한 정제 함수 *//*

    private void refinePolls() {
        IntStream.range(1, polls.size())
                .forEach(i -> polls.set(i, polls.get(i - 1) ? false : polls.get(i)));
    }

    public List<Boolean> getPolls() {
        return polls;
    }
*/
}
