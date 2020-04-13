package console;

import dto.LadderDrawDto;
import dto.LadderResultDto;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ResultView {

    private static final String WHITE_SPACE = "  ";

    public static void printLadderResult(final LadderDrawDto resultDto){
        System.out.println("\n사다리결과");
        printNames(resultDto.getNames());
        printLadder(resultDto.getLines());
        printScores(resultDto.getScores());
    }

    private static void printNames(List<String> names){
        System.out.println(String.join(WHITE_SPACE, names));
    }

    private static void printLadder(List<List<String>> lines){
        lines.forEach(line -> System.out.println(String.join(StringUtils.EMPTY, line)));
    }

    private static void printScores(List<String> scores){
        System.out.println(String.join(WHITE_SPACE, scores));
    }

    public static void printScore(String score){
        System.out.println("\n실행결과");
        System.out.println(score);
    }

    public static void printScoreByNames(LadderResultDto ladderResultDto){
        System.out.println("\n실행결과");
        ladderResultDto.getPlayerResultDtos()
                .forEach(playerResultDto -> System.out.println(playerResultDto.getName() + " : " + playerResultDto.getScore()));
    }
}
