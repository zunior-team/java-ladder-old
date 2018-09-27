package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {
    @Test
    public void generateValidLine(){
        List<Ladder> ladders = LadderGame.makeLadders(5);
        for(Ladder ladder : ladders){
            LadderGame.makeLines(3, ladder);
        }

        for(Ladder ladder : ladders){
            for(int j = 1; j < ladder.getLine().getLines().size(); j++){
                if(ladder.getLine().getLines().get(j-1)){
                    assertThat(ladder.getLine().getLines().get(j)).isFalse();
                }
            }
        }
    }

    @Test
    public void addLine(){
        Line line = new Line();
        for (int i = 0; i < 5; i++) {
            line.addLine();
        }
        assertThat(line.getLines().size()).isEqualTo(5);
    }

    @Test
    public void decideMove(){
        List<Boolean> list = Arrays.asList(true,false,true);
        Line line = new Line(list);
        assertThat(line.decideMove(0)).isEqualTo(1);
        assertThat(line.decideMove(1)).isEqualTo(0);
        assertThat(line.decideMove(2)).isEqualTo(3);
    }

    @Test
    public void isLeft(){
        List<Boolean> list = Arrays.asList(true,false,false);
        Line line = new Line(list);
        assertThat(line.isLeft(0)).isFalse();
        assertThat(line.isLeft(1)).isTrue();
        assertThat(line.isLeft(2)).isFalse();
        assertThat(line.isLeft(3)).isFalse();
    }

    @Test
    public void isRight(){
        List<Boolean> list = Arrays.asList(true,false,false);
        Line line = new Line(list);
        assertThat(line.isRight(0)).isTrue();
        assertThat(line.isRight(1)).isFalse();
        assertThat(line.isRight(2)).isFalse();
        assertThat(line.isRight(3)).isFalse();
    }

    @Test
    public void isLeftSide(){
        List<Boolean> list = Arrays.asList(true,false,false);
        Line line = new Line(list);
        assertThat(line.isLeftSide(0)).isTrue();
    }

    @Test
    public void isRightSide(){
        List<Boolean> list = Arrays.asList(true,false,false);
        Line line = new Line(list);
        assertThat(line.isRightSide(3)).isTrue();
    }
}
