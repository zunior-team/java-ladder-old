package laddergame;

import laddergame.domain.LadderGame;
import laddergame.dto.LadderGameDto;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameLoader {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(InputView.getInputName(), InputView.getInputResult(),InputView.getHeight());
        game.makeLadder();
        LadderGameDto dto = game.getLadderGameResultDto();
        OutputView.printResult(dto);
        OutputView.checkResult(dto.getFinalNamePosition(), dto.getResults());
    }
}
