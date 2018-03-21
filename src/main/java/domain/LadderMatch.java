package domain;

import java.util.ArrayList;

class LadderMatch {
    LadderMatch(LadderGame ladderGame) {
        ArrayList<Player> players = ladderGame.getPlayers();
        ArrayList<LadderLine> ladderLines = Ladder.getLadderLines();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int currentIndex = player.getIndex();
            navigatePath(player, ladderLines, currentIndex);
        }
    }

    private void navigatePath(Player player, ArrayList<LadderLine> ladderLines, int currentIndex) {
        int resultIndex = currentIndex;
        for (LadderLine ladderLine : ladderLines) {
            resultIndex = ladderLine.move(resultIndex);
            player.move(resultIndex);
        }
    }
}
