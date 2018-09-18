package ladderGame;

import java.util.List;

public class ResultView {
    private static final String WALL = "|";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static final int ZERO = 0;
    private static final int INIT_SPACE_LENGTH = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private static StringBuilder sb = new StringBuilder();

    public static void showResult(List<String> names, List<Ladder> laddersOfGame){
        System.out.println("실행결과");
        System.out.println(generateNameUI(names));
        for(Ladder ladder : laddersOfGame){
            System.out.println(generateLineUI(ladder.getLines()));
        }
    }

    // Set Five Length.
    public static String cutFiveLength(String word){
        if(word.length() > MAX_NAME_LENGTH){
            return word.substring(ZERO,MAX_NAME_LENGTH);
        }
        return String.format("%5s", word);
    }

    // Create name line for result UI
    public static String generateNameUI(List<String> names){
        sb.setLength(ZERO);
        for (String name : names) {
            sb.append(cutFiveLength(name)+SPACE);
        }
        return sb.toString();
    }

    // Create 1 height ladder
    public static String generateLineUI(List<Integer> linesOfLadder){
        sb.setLength(ZERO);
        sb.append(generateMultipleWord(SPACE, INIT_SPACE_LENGTH));
        sb.append(WALL);
        for(int line : linesOfLadder){
            sb.append(decideLineUI(line));
            sb.append(WALL);
        }
        return sb.toString();
    }

    // decide hyphen or space
    public static String decideLineUI(int line){
        if(line == ZERO){
            return generateMultipleWord(SPACE, MAX_NAME_LENGTH);
        }
        return generateMultipleWord(HYPHEN, MAX_NAME_LENGTH);
    }

    // word to N words.
    public static String generateMultipleWord(String word, int n){
        String multipleWord = "";
        for(int i = 0; i < n; i++){
            multipleWord += word;
        }
        return multipleWord;
    }
}
