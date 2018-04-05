package ladder.view;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String dashLine = "-----";
    private static final String spaceLine = "     ";
    private static final String pipe = "|";
    private static ArrayList<Player> players;

    public static void printResult(LadderSetting ladderGame) {
        ArrayList<LadderLine> ladderLines = LadderBuilder.getLadderLines();
        players = ladderGame.getPlayers();

        System.out.println("\n사다리 결과\n");
        printNames();
        for (int i = 0; i < ladderLines.size(); i++) {
            printLine(ladderLines.get(i));
        }
        printRewards(ladderGame.getRewards());
    }

    private static void printRewards(ArrayList<String> rewards) {
        for (String reward : rewards) {
            System.out.print(String.format("%-5s", reward));
        }
        System.out.println();
    }

    public static void printTarget(ArrayList<PlayerNReward> playerRewards) {
        System.out.println("\n실행결과");
        int playerRewardsSize = playerRewards.size();
        for (PlayerNReward playerReward : playerRewards) {
            printSingleOrAll(playerReward, playerRewardsSize);
        }
    }

    private static void printSingleOrAll(PlayerNReward playerReward, int playerRewardsSize) {
        if (playerRewardsSize > 1) {
            printAll(playerReward);
        }
        if (playerRewardsSize < 2) {
            printSingle(playerReward);
        }
    }

    private static void printSingle(PlayerNReward playerReward) {
        System.out.println(playerReward.getReward());
    }

    private static void printAll(PlayerNReward playerReward) {
        System.out.println(playerReward.toString());
    }

    private static void printNames() {
        for (Player player : players) {
            System.out.print(String.format("%-6s", player.getName()));
        }
        System.out.println();
    }

    private static void printLine(LadderLine ladderLine) {
        List<Point> points = ladderLine.getPoints();
        Point point;
        for (int i = 0; i < points.size(); i++) {
            point = points.get(i);
            System.out.print(printPipe());
            System.out.print(printBridge(point));
        }
        System.out.println();
    }

    private static String printPipe() {
        return pipe;
    }

    private static String printBridge(Point point) {
        Direction direction = point.getDirection();
        if (direction.isRight()) {
            return dashLine;
        }
        if (!direction.isRight()) {
            return spaceLine;
        }
        return ""; // 마지막 칸.
    }
}
