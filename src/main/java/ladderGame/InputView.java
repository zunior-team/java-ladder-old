package ladderGame;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_NAMES_OF_PLAYER_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 인가요?";
    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputNamesOfPlayer(){
        System.out.println(ASK_NAMES_OF_PLAYER_MESSAGE);
        List<String> names = makeNames(sc.next());
        return names;
    }

    // String to List<String>
    public static List<String> makeNames(String linkedName){
        List<String> names = new ArrayList<>();
        names = Arrays.asList(linkedName.split(","));
        return names;
    }

    public static int inputHeightOfLadder(){
        System.out.println(ASK_HEIGHT_OF_LADDER_MESSAGE);
        return sc.nextInt();
    }

}
