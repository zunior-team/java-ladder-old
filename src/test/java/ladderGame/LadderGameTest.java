package ladderGame;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import javax.xml.transform.Result;
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

    @Test
    public void makeNames(){
        String s = "choising,seungmin,osing";
        List<String> list = InputView.makeNames(s);
        assertEquals(3, list.size());
        assertThat(list.get(0)).isEqualTo("choising");
        assertThat(list.get(1)).isEqualTo("seungmin");
        assertThat(list.get(2)).isEqualTo("osing");
    }

    @Test
    public void cutFiveLength(){
        String s1 = "ssssssssssssssssssss";
        assertEquals(5, ResultView.cutFiveLength(s1).length());
        String s2 = "S";
        assertEquals(5, ResultView.cutFiveLength(s2).length());
    }

    @Test
    public void decideLineUI(){
        int i = 1;
        int j = 0;
        assertThat(ResultView.decideLineUI(i)).isEqualTo("-----");
        assertThat(ResultView.decideLineUI(j)).isEqualTo("     ");
    }

}
