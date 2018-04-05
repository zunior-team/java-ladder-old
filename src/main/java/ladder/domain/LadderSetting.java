package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class LadderSetting {

    private ArrayList<Player> players;
    private ArrayList<String> rewards;
    private ArrayList<PlayerNReward> playerRewards;

    public LadderSetting(int row, String[] names, String[] rewards) {
        LadderBuilder.drawLadderLines(names, row);
        this.players = addPlayers(names);
        this.rewards = new ArrayList<>(Arrays.asList(rewards));
    }

    public ArrayList<Player> addPlayers(String[] names) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }
        return players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getRewards() {
        return rewards;
    }

    public ArrayList<PlayerNReward> getPlayerRewards() {
        playerRewards = new ArrayList<>();
        for (Player player : players) {
            String reward = rewards.get(player.getIndex());
            PlayerNReward playerReward = new PlayerNReward(player, reward);
            playerRewards.add(playerReward);
        }
        return this.playerRewards;
    }


    public ArrayList<PlayerNReward> play(String name) {
        if (name.equals("all")) {
            return this.playerRewards;
        }
        Player player = getMatchedPlayer(name);
        PlayerNReward playerReward = new PlayerNReward(player, rewards.get(player.getIndex()));
        ArrayList<PlayerNReward> playerRewards = new ArrayList<>(); // for single
        playerRewards.add(playerReward);
        return playerRewards;
    }

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


