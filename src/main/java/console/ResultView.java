package console;

import dto.LadderDrawDto;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ResultView {

    private static final String WHITE_SPACE = "  ";

    public static void printLadderResult(final LadderDrawDto resultDto){
        System.out.println("\n실행결과");
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
}
