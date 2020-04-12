package console;

import dto.LadderResultDto;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class LadderGameStarter {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ALL_NAMES = "all";
    private static final String EXIT = "exit";

    public static void run(LadderResultDto ladderResultDto){
        String myAnswer = StringUtils.EMPTY;

        while(isExit(myAnswer)){
            final String name = InputView.inputOnWhoWantToShowingName();
            if(name.equalsIgnoreCase(ALL_NAMES)){

            }
        }
    }

    private static boolean isExit(String answer){
        System.out.println("사다리 게임을 결과를 계속 보시겠습니까? ( 종료시 `exit` 입력 )");
        return  SCANNER.nextLine().equalsIgnoreCase(EXIT);
    }
}
