package ladderGame;

import java.util.List;

public class ResultView {
    private static final String WALL = "|";
    private static final int ZERO = 0;

    private static StringBuilder sb = new StringBuilder();

    public static void showResult(List<Ladder> laddersOfGame){
        for(Ladder ladder : laddersOfGame){
            System.out.println(generateLine(ladder.getLines()));
        }
    }

    public static String generateLine(List<String> linesOfLadder){
        sb.setLength(ZERO);
        sb.append(WALL);
        for(String line : linesOfLadder){
            sb.append(line);
            sb.append(WALL);
        }
        return sb.toString();
    }

}
