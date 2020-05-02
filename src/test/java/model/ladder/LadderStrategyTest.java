package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

@DisplayName("사다리 생성 전략은")
class LadderStrategyTest {

    @Test
    @DisplayName("사다리 생성가능 여부를 반환한다.")
    public void isLineCreatableTest() {
        LadderStrategy ladderStrategy = LadderStrategy.newInstance(10, 0.7D);
        ladderStrategy.isLineCreatable();

        System.out.println(ThreadLocalRandom.current().nextDouble(0, 1));
    }
}