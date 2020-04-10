package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        String participantNames = InputView.inputParticipantNames();
        Participants participants = Participants.of(participantNames);
        int ladderMaxHeight = InputView.inputLadderMaxHeight();
        Ladder ladder = Ladder.of(participants.getParticipants().size(),ladderMaxHeight);
        ResultView.printLadderResult(participants,ladder);

    }
}
