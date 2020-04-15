package ladder.console;

import ladder.Ladder;
import ladder.UserAndPrize;
import ladder.dto.BlockDto;
import ladder.dto.LadderResult;
import ladder.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleOutput {
    public static final String POLL = "-----";
    public static final String FRAME = "|";
    public static final String PADDING = "     ";
    public static final char NEW_LINE = '\n';

    private static String drawBlocks(List<BlockDto> blockDto) {
        StringBuilder stringBuilder = new StringBuilder();

        blockDto.stream()
                .map(BlockDto::getPolls)
                .map(ConsoleOutput::drawBlock)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private static String drawUserOrPrize(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();

        strings.forEach(userName -> stringBuilder.append(String.format("%6s", userName)));

        return stringBuilder.toString();
    }

    private static String drawBlock(List<Boolean> polls) {
        StringBuilder stringBuilder = new StringBuilder(PADDING);

        polls.forEach(isPollExist -> stringBuilder.append(FRAME)
                .append(isPollExist ? POLL : PADDING)
        );

        stringBuilder.append(NEW_LINE);

        return stringBuilder.toString();
    }

    private static void showResult() {
        System.out.println("실행 결과");
    }

    public static void drawLadder(UserAndPrize usersAndPrizes, Ladder ladder) {
        List<String> userNames = usersAndPrizes.getUsers()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());

        List<String> prizes = usersAndPrizes.getPrizes();

        showResult();
        System.out.println(drawUserOrPrize(userNames));
        System.out.print(drawBlocks(ladder.toBlockDtos()));
        System.out.println(drawUserOrPrize(prizes));
    }

    public static void showTargetPrize(LadderResult ladderResult, String target) {
        Map<String, String> prizeMatch = ladderResult.getPrizeMatch();
        System.out.println("실행 결과");
        if("all".equalsIgnoreCase(target)) {
            showTarget(prizeMatch, new ArrayList<>(prizeMatch.values()));
        } else {
            showTarget(prizeMatch, Collections.singletonList(target));
        }
    }

    public static void showTarget(Map<String, String> ladderResult, List<String> targets) {
        targets.forEach(target -> System.out.println(target + " : " + ladderResult.get(target)));
    }
}
