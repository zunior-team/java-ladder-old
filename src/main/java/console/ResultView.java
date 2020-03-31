package console;

import dto.LadderResultDto;

import java.util.List;

public class ResultView {

    private static final String WHITE_SPACE = "  ";
    private static final String NONE_SPACE = "";

    public static void printLadderResult(final LadderResultDto resultDto){
        System.out.println("\n실행결과");
        printNames(resultDto.getNames());
        printLadder(resultDto.getLines());
    }

    private static void printNames(List<String> names){
        System.out.println(String.join(WHITE_SPACE, names));
    }

    private static void printLadder(List<List<String>> lines){
        for(List<String> line : lines){
            System.out.println(String.join(NONE_SPACE, line));
        }
    }
}
