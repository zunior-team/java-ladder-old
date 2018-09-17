package ladderGame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void goGame(int numberOfPlayers, int numberOfLadder){
        List<Ladder> ladders = makeLadders(numberOfLadder);
        for(Ladder ladder : ladders){
            makeLines(numberOfPlayers, ladder);
        }
        ResultView.showResult(ladders);
    }

    // Create Ladder instance.
    public static List<Ladder> makeLadders(int numberOfLadder){
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < numberOfLadder; i++){
            ladders.add(new Ladder());
        }
        return ladders;
    }

    // Call Ladder's makeLine Method.
    public static void makeLines(int numberOfPlayer, Ladder ladder){
        for(int i = 0; i < numberOfPlayer - 1; i++){
            ladder.makeLine();
        }
    }

    public static void main(String[] args) {
        LadderGame.goGame(InputView.inputNumberOfPlayer(), InputView.inputHeightOfLadder());
    }
}
