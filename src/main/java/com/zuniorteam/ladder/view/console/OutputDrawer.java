package com.zuniorteam.ladder.view.console;

import com.zuniorteam.ladder.core.Ladder;
import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public final class OutputDrawer {

    private static final String NEW_LINE = "\n";
    private static final Character BRIDGE_TOKEN = '-';
    private static final Character BLANK_TOKEN = ' ';
    private static final Character BORDER_TOKEN = '|';

    private OutputDrawer() {}

    public static String drawUsers(List<User> users, int bridgeLength) {
        final String drawUsers = users.stream()
                .map(User::getUsername)
                .map(username -> StringUtil.fill(username, BLANK_TOKEN, bridgeLength))
                .collect(joining(BLANK_TOKEN.toString()));

        return StringUtil.fill(BLANK_TOKEN, bridgeLength) + drawUsers;
    }

    public static String drawResults(List<String> results, int bridgeLength) {
        final String drawResults = results.stream()
                .map(result -> StringUtil.fill(result, BLANK_TOKEN, bridgeLength))
                .collect(joining(BLANK_TOKEN.toString()));

        return StringUtil.fill(BLANK_TOKEN, bridgeLength) + drawResults;
    }

    public static List<String> drawAllUserToResults(List<User> users, Map<User, String> userToResult) {
        return users.stream()
                .map(user -> drawUserToResult(user, userToResult.get(user)))
                .collect(Collectors.toList());
    }

    public static String drawUserToResult(User checkUser, String result) {
        return String.format("%s : %s", checkUser.getUsername(), result);
    }

    public static String drawLadder(Ladder ladder, int bridgeLength) {
        return ladder.getLines().stream()
                .map(line -> drawLine(line, bridgeLength))
                .collect(joining(NEW_LINE));
    }

    private static String drawLine(Line line, int bridgeLength) {
        final String drawLine = IntStream.range(0, line.getLength())
                .mapToObj(index -> drawBridge(line, index, bridgeLength))
                .collect(joining(BORDER_TOKEN.toString(), BORDER_TOKEN.toString(), BORDER_TOKEN.toString()));

        return StringUtil.fill(BLANK_TOKEN, bridgeLength) + drawLine;
    }

    private static String drawBridge(Line line, int index, int bridgeLength) {
        if (line.hasBridge(index)) {
            return StringUtil.fill(BRIDGE_TOKEN, bridgeLength);
        }

        return StringUtil.fill(BLANK_TOKEN, bridgeLength);
    }


}
