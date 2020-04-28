package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        String participantNames = InputView.inputParticipantNames();
        Participants participants = Participants.of(participantNames);

        String inputResults = InputView.inputResult();
        Results results = new Results(inputResults);

        int ladderMaxHeight = InputView.inputLadderMaxHeight();
        Ladder ladder = Ladder.of(participants.getParticipants().size(),ladderMaxHeight);

        ResultView.printLadder(participants,ladder,results);

        LadderGame ladderGame = new LadderGame(ladder,participants,results);
        LadderResult ladderResult = ladderGame.play();

        String participantName = InputView.inputParticipantName();
        Participant participant = participants.getParticipantByName(participantName);

        ResultView.printLadderResult(participant,ladderResult);


    }
}
