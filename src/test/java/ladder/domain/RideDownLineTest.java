package ladder.domain;

import ladder.dto.LadderDto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RideDownLineTest {
    RideDownLine rideDownLine;

    @Before
    public void before(){
        List<String> names = Arrays.asList("pobi", "honux", "choising", "taesu");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderDto ladderDto = new LadderDto(names, ladders);
        LadderGame.fillLadder(ladderDto);
        rideDownLine = new RideDownLine(ladderDto);
    }

    @Test
    public void goRideDown(){
        assertThat(rideDownLine.goRideDown("choising")).isBetween(0, 3);
    }

    @Test
    public void goRideDownEveryOne(){
        assertThat(rideDownLine.goRideDownEveryOne().size()).isEqualTo(4);
    }

    @Test
    public void findNameIndex(){
        assertThat(rideDownLine.findNameIndex("choising")).isEqualTo(2);
    }

    @Test
    public void rideDownPersonResult(){
        assertThat(rideDownLine.rideDownPersonResult(2)).isBetween(0, 3);
    }

}
