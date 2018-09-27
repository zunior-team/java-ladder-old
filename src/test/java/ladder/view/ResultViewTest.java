package ladder.view;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ResultViewTest {
    @Test
    public void generateLineUI(){
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        System.out.println(ResultView.generateLineUI(list));
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
        boolean i = true;
        boolean j = false;
        assertThat(ResultView.decideLineUI(i)).isEqualTo("-----");
        assertThat(ResultView.decideLineUI(j)).isEqualTo("     ");
    }

    @Test
    public void generateMultipleWord(){
        String s = "ab";
        assertThat(ResultView.generateMultipleWord(s,3)).isEqualTo("ababab");
    }
}
