package lottoGame.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LottoMain {

    ArrayList<Lotto> lotto = new ArrayList<>();
    int count = 0;
    int win = 0;
    public ArrayList<Lotto> in(){           //객체생성
        for (int i = 0; i < 6; i++) {
        //    lotto.add(new Lotto(i));
        }
        return lotto;
    }

    public ArrayList<Lotto> instanceBoom(ArrayList<Integer> com, int bonusNo){
        if(count > 3){
            lotto.add(new Lotto("꽝",count));
        }

        if(count == 6){
            lotto.add(new Lotto("1",count));
        }

        if(count == 5 && com.contains(bonusNo) == true){
            lotto.add(new Lotto("2",count));
        }

        for (int i = 3; i <= 5; i++) {
            //for (int j = 0; j < 5; j++) {

            //}
            lotto.add(new Lotto("i",count));
        }

        if(count == 5){
            lotto.add(new Lotto("3",count));
        }

        if(count == 4){
            lotto.add(new Lotto("4",count));
        }

        if(count == 3){
            lotto.add(new Lotto("5",count));
        }
        return lotto;
    }



    public int winner2(ArrayList<Integer> com, int bonusNo){
        if(lotto.get(4).num == win && com.contains(bonusNo) == true){
            return win = 2;
        }else{
            return win = 3;
        }
    }
    public void winner0(){
        if (count < 3) {
            System.out.print("꽝");
        }
    }

    public int winnerComparison(){
        for (int i = 0; i < 6; i++) {
            if(lotto.get(i).num == count){
            }
        }
        return count;
    }

    public int getMax(ArrayList<Integer> user, ArrayList<Integer> com) {
        for (int i = 0; i < com.size(); i++) {
            if (com.contains(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean a(){                //중복체크
        HashSet<Integer> h = new HashSet<>();
        boolean c = false;
        if(h.size() <6){
            c = true;
        }
        return c;
    }
}
