package console;

import dto.LadderResultDto;

import java.util.Scanner;

public class LadderGameStarter {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ALL_NAMES = "all";
    private static final String EXIT = "exit";

    public static void run(LadderResultDto ladderResultDto){

        while(true){

            showLadderResultByInput(InputView.inputToShowingName(), ladderResultDto);

            if(isExit()){
                break;
            }
        }
    }

    private static void showLadderResultByInput(final String name, final LadderResultDto ladderResultDto){
        if(name.equalsIgnoreCase(ALL_NAMES)){
            ResultView.printScoreByNames(ladderResultDto);
        } else {
            ResultView.printScore(ladderResultDto.getScoreByName(name));
        }
    }

    private static boolean isExit(){
        System.out.println("\n사다리 게임을 결과를 계속 보시겠습니까? ( 진행시 무작위 키, 종료시 `exit` 입력 )");
        return SCANNER.nextLine().equalsIgnoreCase(EXIT);
    }
}
