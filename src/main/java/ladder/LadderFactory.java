package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.RideDownLine;
import ladder.dto.LadderDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderFactory {
    private static final String EVERYONE = "all";
    private LadderDto ladderDto;

    public LadderFactory(LadderDto ladderDto) {
        this.ladderDto = ladderDto;
    }

    public static void main(String[] args) {
        List<String> names = InputView.inputNamesOfPlayer();
        List<String> results = InputView.inputResult();
        List<Ladder> ladders = LadderGame.makeLadders(InputView.inputHeightOfLadder());

        LadderDto ladderDto = new LadderDto(names, ladders, results);
        LadderGame.fillLadder(ladderDto);
        ResultView.showLadderResult(ladderDto);

        LadderFactory ladderFactory = new LadderFactory(ladderDto);
        ladderFactory.showRideDownResult();
    }

    public void showRideDownResult(){
        ResultView.executeResultMessage();
        String name = InputView.inputPlayerResult();
        RideDownLine rideDownLine = new RideDownLine(this.ladderDto);
        if(isEveryOne(name)){
            showEveryOneResult(rideDownLine);
            return;
        }
        showAloneResult(rideDownLine, name);
        return;
    }

    public void showEveryOneResult(RideDownLine rideDownLine){
        List<Integer> answers = rideDownLine.goRideDownEveryOne();
        ResultView.everyOneResultUI(ladderDto, answers);
    }

    public void showAloneResult(RideDownLine rideDownLine, String name){
        int answer = rideDownLine.goRideDown(name);
        ResultView.personResultUI(answer, this.ladderDto.getResults());
    }

    public static boolean isEveryOne(String value){
        return value.equals(EVERYONE);
    }

}
