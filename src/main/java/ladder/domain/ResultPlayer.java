package ladder.domain;

public class ResultPlayer {
    public static final String ALL = "all";
    private Player player;
    private boolean isAll;

    public ResultPlayer(Players players, String name) {
        if (ALL.equals(name)) {
            isAll = true;
            return;
        }
        player = players.findByName(name);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAll() {
        return isAll;
    }
}
