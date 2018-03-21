package domain;

public class PlayerReward {
    private Player player;
    private String reward;

    PlayerReward(Player player, String reward) {
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
