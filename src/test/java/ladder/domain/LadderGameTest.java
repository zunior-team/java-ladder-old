package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.dto.LadderDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LadderGameTest {
    @Test
    public void makeLadders(){
        assertThat(LadderGame.makeLadders(3).size()).isEqualTo(3);
    }

    @Test
    public void makeLines(){
        Ladder ladder = new Ladder();
        LadderGame.makeLines(3, ladder);
        assertThat(ladder.getLine().getLines().size()).isEqualTo(2);
    }

    @Test
    public void fillLadder(){
        List<String> names = Arrays.asList("pobi", "honux", "choising", "taesu");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderDto ladderDto = new LadderDto(names, ladders);
        LadderGame.fillLadder(ladderDto);
        assertThat(ladders.get(0).getLine().getLines().size()).isEqualTo(3);
    }
}
