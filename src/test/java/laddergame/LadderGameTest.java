package laddergame;

import laddergame.domain.*;
import laddergame.utils.StringUtil;
import laddergame.view.ResultView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void lineTEst() {
        Boolean[] a = {true, false, false, true};
        ArrayList<Boolean> line = new ArrayList(Arrays.asList(a));
        // ture,false,false,true
        //      l-----l     l     l-----l
        String istrue = "     l-----l     l     l-----l";
        assertThat(StringUtil.toStringLadder(line).toString()).isEqualTo(istrue);
    }

    // "aa" 를 입력하면 "aa   " 를 반환
    @Test
    public void isResultLengthFIve() {
        int isTrue = 5;
        StringBuffer result = StringUtil.namesPosition("aa");
        assertThat(result.length()).isEqualTo(isTrue);
    }

    @Test
    public void ladderMainTest() {
        String person = "qwe,asd,zxcs,we,qee";
        int height = 5;
        LadderGame ladderGame = new LadderGame(person, height);
        ladderGame.run();
        ResultView.printResult(ladderGame);
    }


    @Test
    public void userTest() {
        User user = new User("pobi", 1);
        assertThat(user.getName()).isEqualTo("pobi");
    }

    @Test
    public void isTrue() {
        for (int i = 0; i < 5; i++) {
            boolean random = Line.isTrue();
            System.out.println(random);
        }
    }

    @Test
    public void makeLine() {
        ArrayList<Boolean> line = Line.makeLine(5);
        for (int i = 0; i < line.size(); i++) {
            System.out.println(line.get(i));
        }
        assertThat(line.get(0)).isEqualTo(true);
    }

    @Test
    public void isLine() {
        String line = StringUtil.lineOrBlank(true);

        assertThat(line).isEqualTo("-----");
    }

    @Test
    public void isBlank() {
        String line = StringUtil.lineOrBlank(false);

        assertThat(line).isEqualTo("     ");
    }
}
