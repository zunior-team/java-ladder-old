package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private ArrayList<Player> players;
    private List<String> rewards;
    private ArrayList<PlayerReward> playerRewards; // for all

    LadderGame(String[] names, String[] rewards, int height) {
        Ladder.makeLadderLines(names, height);
        this.players = makePlayers(names);
        this.rewards = Arrays.asList(rewards);
    }

    public ArrayList<Player> makePlayers(String[] names) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }
        return players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public ArrayList<PlayerReward> getPlayerRewards() {
        playerRewards = new ArrayList<>();
        for (Player player : players) {
            String reward = rewards.get(player.getIndex());
            PlayerReward playerReward = new PlayerReward(player, reward);
            playerRewards.add(playerReward);
        }
        return this.playerRewards;
    }

    public ArrayList<PlayerReward> play(String name) {
        if (name.equals("all")) {
            return this.playerRewards;
        }
        Player player = getMatchedPlayer(name);
        PlayerReward playerReward = new PlayerReward(player, rewards.get(player.getIndex()));
        ArrayList<PlayerReward> playerRewards = new ArrayList<>(); // for single
        playerRewards.add(playerReward);
        return playerRewards;
    }

    // TODO 더 나은 방법이 없는지 고민하기
    private Player getMatchedPlayer(String name) {
        Player result = new Player(name, 0);
        for (Player player : players) {
            if (player.equals(result)) {
                return player;
            }
        }
        return null;
    }
}