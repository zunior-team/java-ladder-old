package ladderGame;

import java.util.List;

public class ResultView {
    private static final String WALL = "|";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static final int ZERO = 0;

    private static StringBuilder sb = new StringBuilder();

    public static void showResult(List<Ladder> laddersOfGame){
        for(Ladder ladder : laddersOfGame){
            System.out.println(generateLineUI(ladder.getLines()));
        }
    }

    public static String generateLineUI(List<Integer> linesOfLadder){
        sb.setLength(ZERO);
        sb.append(WALL);
        for(int line : linesOfLadder){
            sb.append(line == ZERO ? SPACE : HYPHEN);
            sb.append(WALL);
        }
        return sb.toString();
    }

}
