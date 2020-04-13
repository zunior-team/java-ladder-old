package console;

import dto.LadderResultDto;

import java.util.Scanner;

public class LadderGameStarter {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ALL_NAMES = "all";
    private static final String EXIT = "exit";

    public static void run(LadderResultDto ladderResultDto){

        while(!isExit()){

            final String name = InputView.inputToShowingName();

            if(name.equalsIgnoreCase(ALL_NAMES)){
                ResultView.printScoreByNames(ladderResultDto);
            } else {
                ResultView.printScore(ladderResultDto.getScoreByName(name));
            }
        }
    }

    private static boolean isExit(){
        System.out.println("\n사다리 게임을 결과를 보시겠습니까? ( 진행시 무작위 키, 종료시 `exit` 입력 )");
        return  SCANNER.next().equalsIgnoreCase(EXIT);
    }
}
