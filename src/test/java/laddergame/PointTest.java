package laddergame;

import laddergame.domain.LadderGame;
import laddergame.domain.Line;
import laddergame.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void userMove3() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter"};
        ArrayList<User> users = ladderGame.makeUsers(members);
        ArrayList<Boolean> line2 = new ArrayList<Boolean>(Arrays.asList(true));

        movePosition2(users, line2);
    }

    // 유저에 넣어야 하나? 게임에 넣어야 하나?
    private void movePosition2(ArrayList<User> users, ArrayList<Boolean> line2) {
        boolean isRight = false;
        boolean isLeft = false;
        for (int i = 1; i < users.size() - 1; i++) {
            // i 자리의 ladder 값에 대해 i-1 i+1 의 line 값을 판별 하고
            //isRight 와 isLeft 의 값을 line이랑 비교해서 true false 구해서 두개 실행
            isLeft = line2.get(i - 1);
            //System.out.println(i - 1 +" 이것의 왼쪽 " + line2.get(i - 1));
            isRight = line2.get(i);
        }
    }

    @Test
    public void userTest() {
        LadderGame ladderGame = new LadderGame();
        String[] members = {"pobi", "peter", "nana", "toto", "moka"};
        ArrayList<User> users = ladderGame.makeUsers(members);
    }

    @Test
    public void ladderTest() {
        ArrayList<Boolean> line = new ArrayList<Boolean>(Arrays.asList(true, false, false, false));
        Line line1 = new Line(line);
        assertThat(line1.isMove(0)).isTrue();
        assertThat(line1.isMove(1)).isFalse();
    }


}
