package ladderGame;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderGameTest {
    @Test
    public void makeLadder(){
        assertEquals(3, LadderGame.makeLadders(3).size());
    }
    @Test
    public void makeLines(){
        Ladder ladder = new Ladder();
        LadderGame.makeLines(3, ladder);
        assertEquals(2, ladder.getLines().size());
    }
    @Test
    public void generateRandom(){
        assertTrue(Ladder.generateRandom() == 0 || Ladder.generateRandom() == 1);
    }

    @Test
    public void generateLineUI(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        System.out.println(ResultView.generateLineUI(list));
    }

    @Test
    public void validLine(){
        List<Ladder> ladders = LadderGame.makeLadders(5);
        for(Ladder ladder : ladders){
            LadderGame.makeLines(3, ladder);
        }

        for(Ladder ladder : ladders){
            for(int j = 1; j < ladder.getLines().size(); j++){
                if(ladder.getLines().get(j-1) == 1){
                    assertEquals(0, (int)ladder.getLines().get(j));
                }
            }
        }
    }

}
