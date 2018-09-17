package ladderGame;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_OF_PLAYER_MESSAGE = "참여할 사람은 몇 명 인가요?";
    private static final String ASK_HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 인가요?";
    private static Scanner sc = new Scanner(System.in);

    public static int inputNumberOfPlayer(){
        System.out.println(ASK_NUMBER_OF_PLAYER_MESSAGE);
        return sc.nextInt();
    }

    public static int inputHeightOfLadder(){
        System.out.println(ASK_HEIGHT_OF_LADDER_MESSAGE);
        return sc.nextInt();
    }

}
