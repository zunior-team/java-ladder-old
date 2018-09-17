package ladderGame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private static void goGame(int numberOfPlayers, int numberOfLadder){
        List<Ladder> ladders = makeLadder(numberOfLadder);
        for(Ladder ladder : ladders){
            makeLines(numberOfPlayers, ladder);
        }
        ResultView.showResult(ladders);
    }

    private static List<Ladder> makeLadder(int numberOfLadder){
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < numberOfLadder; i++){
            ladders.add(new Ladder());
        }
        return ladders;
    }

    private static void makeLines(int numberOfPlayer, Ladder ladder){
        for(int i = 0; i < numberOfPlayer - 1; i++){
            ladder.makeLine();
        }
    }

    public static void main(String[] args) {
        LadderGame.goGame(InputView.inputNumberOfPlayer(), InputView.inputHeightOfLadder());
    }
}
