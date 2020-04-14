package ladder.prize;

import java.util.List;

public class Prizes {
    private List<String> prizes;

    public Prizes(List<String> prizes) {

    }

    public String getPrize(int position) {
        return prizes.get(position);
    }
}
