package ladder.console;

import ladder.dto.BlockDto;
import ladder.dto.LadderResult;

import java.util.List;

public class ConsoleOutput {
    public static final String POLL = "-----";
    public static final String FRAME = "|";
    public static final String PADDING = "     ";
    public static final char NEW_LINE = '\n';

    public static void drawResult(LadderResult result) {
        showResult();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(drawUser(result.getUserNames()));
        stringBuilder.append(drawBlocks(result.getBlockDto()));

        System.out.println(stringBuilder.toString());
    }

    private static String drawBlocks(List<BlockDto> blockDto) {
        StringBuilder stringBuilder = new StringBuilder();

        blockDto.stream()
                .map(BlockDto::getPolls)
                .map(ConsoleOutput::drawBlock)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private static String drawUser(List<String> userNames) {
        StringBuilder stringBuilder = new StringBuilder();

        userNames.forEach(userName -> stringBuilder.append(String.format("%6s", userName)));

        return stringBuilder.toString();
    }

    private static String drawBlock(List<Boolean> polls) {
        StringBuilder stringBuilder = new StringBuilder(PADDING);

        polls.forEach(isPollExist -> stringBuilder.append(FRAME)
                .append(isPollExist ? POLL : PADDING)
        );

        stringBuilder.append(FRAME)
                .append(NEW_LINE);

        return stringBuilder.toString();
    }

    private static void showResult() {
        System.out.println("실행 결과");
    }
}
