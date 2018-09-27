package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_NAMES_OF_PLAYER_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 인가요?";
    private static final String ASK_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String SPLITTER = ",";
    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputNamesOfPlayer(){
        System.out.println(ASK_NAMES_OF_PLAYER_MESSAGE);
        List<String> names = doSplit(sc.next());
        return names;
    }

    // String to List<String>
    public static List<String> doSplit(String connectedData){
        List<String> splitData = new ArrayList<>();
        splitData = Arrays.asList(connectedData.split(SPLITTER));
        return splitData;
    }

    public static int inputHeightOfLadder(){
        System.out.println(ASK_HEIGHT_OF_LADDER_MESSAGE);
        return sc.nextInt();
    }

    public static List<String> inputResult(){
        System.out.println(ASK_RESULT_MESSAGE);
        List<String> results = doSplit(sc.next());
        return results;                
    }

    public static String inputPlayerResult(){
        System.out.println(ASK_PLAYER_RESULT_MESSAGE);
        return sc.next();
    }
}
