package com.zuniorteam.ladder.view.console;

import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputConsole {

    private static final char BRIDGE = '-';
    private static final char BLANK = ' ';
    private static final String BORDER = "|";
    private static final String NEW_LINE = "\n";

    private static final int LENGTH = 5;

    public void drawResult(List<User> users, List<Line> ladder) {
        final String result = new StringBuilder()
                .append(StringUtils.fillRest("", BLANK, LENGTH))
                .append(drawUsers(users))
                .append("\n")
                .append(drawLadder(ladder))
                .toString();

        System.out.println(result);
    }

    private String drawUsers(List<User> users) {
        return users.stream()
                .map(User::getUsername)
                .map(username -> StringUtils.fillRest(username, BLANK, LENGTH))
                .collect(Collectors.joining(BLANK + ""));
    }

    private String drawLadder(List<Line> ladder) {
        return ladder.stream()
                .map(this::drawLine)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String drawLine(Line line) {
        final String drawLine = IntStream.range(0, line.getLength())
                .mapToObj(index -> drawBridge(line, index))
                .collect(Collectors.joining(BORDER));

        return drawLine + BORDER;
    }

    private String drawBridge(Line line, int index) {
        if (line.hasBridge(index)) {
            return StringUtils.fillRest("", BRIDGE, LENGTH);
        }

        return StringUtils.fillRest("", BLANK, LENGTH);
    }
}
