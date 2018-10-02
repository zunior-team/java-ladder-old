package laddergame.utils;

import laddergame.domain.LadderGame;

import java.util.ArrayList;

public class MyStringUtil {
    private static final String RADDER_BLANK = "     ";
    private static final String RADDER = "-----";
    private static final String BLANK = " ";
    private static final String STRING_L = "l";
    private static final int NAME_LENGTH = 5;

    public static StringBuffer toStringLadder(ArrayList<Boolean> isLadder) {
        StringBuffer ladder = new StringBuffer(RADDER_BLANK);
        for (Boolean aBoolean : isLadder) {
            ladder.append(STRING_L);
            ladder.append(lineOrBlank(aBoolean));
        }
        ladder.append(STRING_L);
        return ladder;
    }

    public static String lineOrBlank(Boolean isTrue) {
        String line = RADDER_BLANK;
        if (isTrue) {
            line = RADDER;
        }
        return line;
    }

    public static StringBuffer displayPosition(String member) {
        StringBuffer memberName = new StringBuffer(member);
        for (int i = member.length(); i < NAME_LENGTH; i++) {
            if (memberName.length() < NAME_LENGTH) {
                memberName.append(BLANK);
            }
        }
        return memberName;
    }

    // result 값과 유저 위치와 같은지 비교후 같으면 그곳 출력
    public static String nameResultToString(LadderGame ladderGame, int i) {
        return ladderGame.getUsers().get(i).getName() + " : " +
                ladderGame.getResults().get(ladderGame.findResultPosition(i)).getResult();
    }

}
