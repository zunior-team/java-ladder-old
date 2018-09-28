package laddergame.domain;

import laddergame.dto.LadderGameDto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private List<String> names;
    private List<String> results;
    private LadderGame game;

    @Before
    public void before() {
        names = Arrays.asList("n1", "n2", "n3");
        results = Arrays.asList("r1", "r2", "r3");
        game = new LadderGame(names, results,4);
    }

    @Test
    public void initLadderGame() {
        LadderGameDto dto = game.getLadderGameResultDto();
        assertThat(dto.getNames()).isEqualTo(names);
        assertThat(dto.getResults()).isEqualTo(results);
    }

    @Test
    public void initLadder() {
        LadderGameDto dto = game.getLadderGameResultDto();

        Ladder ladder = dto.getLadder();
        assertThat(ladder.size()).isEqualTo(4);

        Line firstLine = ladder.getLine(0);
        assertThat(firstLine.size()).isEqualTo(names.size() - 1);
    }

    @Test
    public void copyLadder() {
        game.makeLadder();
        LadderGameDto dto = game.getLadderGameResultDto();
    }
}
