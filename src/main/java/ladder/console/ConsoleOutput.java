package ladder.console;

import ladder.dto.BlockDto;
import ladder.dto.LadderResult;

public class ConsoleOutput {
    public static final String POLL = "-----";
    public static final String FRAME = "|";
    public static final String PADDING = "     ";
    public static final char NEW_LINE = '\n';

    public static void drawResult(LadderResult result) {
        showResult();

        StringBuilder stringBuilder = new StringBuilder();

        appendUsers(result, stringBuilder);
        appendBlocks(result, stringBuilder);

        System.out.println(stringBuilder.toString());
    }

    private static void appendBlocks(LadderResult result, StringBuilder stringBuilder) {
        result.getBlockDto()
                .stream()
                .map(BlockDto::getPolls)
                .forEachOrdered(booleans -> {
                    stringBuilder.append(PADDING);
                    booleans.forEach(bool -> {
                            stringBuilder.append(FRAME)
                                    .append(bool ? POLL : PADDING);
                        });
                    stringBuilder.append(FRAME)
                            .append(NEW_LINE);
                });

        stringBuilder.append(NEW_LINE);
    }

    private static void appendUsers(LadderResult result, StringBuilder stringBuilder) {
        result.getUserNames()
                .forEach(userName -> {
                    stringBuilder.append(String.format("%6s", userName));
                });
        stringBuilder.append('\n');
    }

    private static void showResult() {
        System.out.println("실행 결과");
    }
}
