package com.zuniorteam.ladder.view.console;

import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class OutputDrawer {

    private static final String NEW_LINE = "\n";

    private static final Character BRIDGE_TOKEN = '-';
    private static final Character UNBRIDGE_TOKEN = ' ';
    private static final Character BORDER_TOKEN = '|';

    public static String drawUsers(List<User> users, int bridgeLength) {
        return StringUtils.fill(UNBRIDGE_TOKEN, bridgeLength)
                + users.stream()
                .map(User::getUsername)
                .map(username -> StringUtils.fill(username, UNBRIDGE_TOKEN, bridgeLength))
                .collect(joining(UNBRIDGE_TOKEN.toString()));
    }

    public static String drawLadder(List<Line> ladder, int bridgeLength) {
        return ladder.stream()
                .map(line -> drawLine(line, bridgeLength))
                .collect(joining(NEW_LINE));
    }

    private static String drawLine(Line line, int bridgeLength) {
        final String drawLine = IntStream.range(0, line.getLength())
                .mapToObj(index -> drawBridge(line, index, bridgeLength))
                .collect(joining(BORDER_TOKEN.toString()));

        return drawLine + BORDER_TOKEN;
    }

    private static String drawBridge(Line line, int index, int bridgeLength) {
        if (line.hasBridge(index)) {
            return StringUtils.fill(BRIDGE_TOKEN, bridgeLength);
        }

        return StringUtils.fill(UNBRIDGE_TOKEN, bridgeLength);
    }
}
