package ladder.prize;

import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public String getPrize(int position) {
        return prizes.get(position);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
