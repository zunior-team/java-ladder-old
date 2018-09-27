package ladder.domain;

import ladder.dto.LadderDto;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    // Create Ladder instance
    public static List<Ladder> makeLadders(int numberOfLadder){
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < numberOfLadder; i++){
            ladders.add(new Ladder());
        }
        return ladders;
    }

    // Fill ladders with line
    public static void fillLadder(LadderDto ladderDto){
        List<Ladder> ladders = ladderDto.getLadders();
        int numberOfPlayers = ladderDto.getNamesSize();
        for(Ladder ladder : ladders){
            makeLines(numberOfPlayers, ladder);
        }
    }

    // Call Ladder's makeLine method
    public static void makeLines(int numberOfPlayer, Ladder ladder){
        for(int i = 0; i < numberOfPlayer - 1; i++){
            ladder.makeLine();
        }
    }
}
