package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMainTest {
    @Test
    public void 등수1(){

    }

    @Test
    public void 중복_확인(){
        int[] user = {1,5,32,45,7,9};
        int[] com = {1,2,31,45,9,0};

      //  assertThat(LottoMain.a()).isEqualTo(true);
    }

    @Test
    public void 값_비교(){
        ArrayList<Integer> user = new ArrayList<>();
        ArrayList<Integer> com = new ArrayList<>();
        int num = 9;

        user.add(1);
        user.add(2);
        user.add(3);
        user.add(4);
        user.add(5);
        user.add(6);

        com.add(1);
        com.add(2);
        com.add(3);
        com.add(7);
        com.add(9);
        com.add(25);

        //assertThat(LottoMain.getMax(user,com,9)).isEqualTo(4);
    }


}
