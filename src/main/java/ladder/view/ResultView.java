package ladder.view;

import ladder.domain.ResultPlayer;
import ladder.domain.Results;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    protected static final String SPACE_BETWEEN_NAMES = "    ";
    protected static final String ONE_SHORT_LINE = "|";
    protected static final String BAR_LINE = "--------";
    protected static final String EMPTY_SPACE_BETWEEN_BAR = "        ";

    public void printLadder(LadderGame ladderGame) {
        System.out.println("실행 결과");
        final Players players = ladderGame.players();
        final List<Line> lines = ladderGame.lines();

        System.out.println(String.join(SPACE_BETWEEN_NAMES, players.names()));

        lines.stream()
                .map(this::convertToPrintFormat)
                .forEachOrdered(System.out::println);

        final Results resultNames = ladderGame.results();
        System.out.println(String.join(SPACE_BETWEEN_NAMES, resultNames.names()));
    }

    private String convertToPrintFormat(Line line) {
        final StringBuilder lineStringBuilder = new StringBuilder(ONE_SHORT_LINE);
        IntStream.range(0, line.playerCount())
                .forEach(index -> {
                    lineStringBuilder.append(line.hasBridge(index) ? BAR_LINE : EMPTY_SPACE_BETWEEN_BAR);
                    lineStringBuilder.append(ONE_SHORT_LINE);
                });
        return lineStringBuilder.toString();
    }

    public void printResultOfEachPlayer(LadderGame ladderGame, ResultPlayer resultPlayer) {
        if (resultPlayer.isAll()) {
            ladderGame.players().stream()
                    .map(player -> player + ":" + ladderGame.findResult(player))
                    .forEachOrdered(System.out::println);
            return;
        }

        System.out.println(ladderGame.findResult(resultPlayer.getPlayer()));
    }

}
