package ladder.view;

import ladder.domain.*;
import ladder.dto.LadderGameResultDto;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {

    protected static final String SPACE_BETWEEN_NAMES = "    ";
    protected static final String ONE_SHORT_LINE = "|";
    protected static final String BAR_LINE = "--------";
    protected static final String EMPTY_SPACE_BETWEEN_BAR = "        ";

    public void printLadder(LadderGameResultDto ladderGame) {
        System.out.println("실행 결과");
        final Players players = ladderGame.getPlayers();
        final Lines lines = ladderGame.getLines();

        System.out.println(String.join(SPACE_BETWEEN_NAMES, players.names()));

        lines.stream()
                .map(this::convertToPrintFormat)
                .forEachOrdered(System.out::println);

        final Results resultNames = ladderGame.getResults();
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

    public void printResultOfEachPlayer(Map<Player, String> resultOfPlayers, ResultPlayer resultPlayer) {
        if (resultPlayer.isAll()) {
            resultOfPlayers.forEach((player, result) -> System.out.println(player + " : " + "result"));
            return;
        }

        System.out.println(resultOfPlayers.getOrDefault(resultPlayer.getPlayer(), "응답이 존재하지 않습니다"));
    }

}
