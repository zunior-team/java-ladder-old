package ladder.domain;

public class PlayerNReward {
    private Player player;
    private String reward;

    PlayerNReward(Player player, String reward) {
        this.player = player;
        this.reward = reward;
    }

    public String getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return this.player.getName() + " : " + this.reward;
    }
}
