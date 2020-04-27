package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Participants participants;
    private final Results results;

    public LadderGame(Ladder ladder,Participants participants,Results results){
        this.ladder = ladder;
        this.participants = participants;
        this.results = results;
    }
    public LadderResult play(){

        //int order = 0;
        List<Participant> participants = this.participants.getParticipants();

        int lineWidth = ladder.getLineWidth();
        List<Line> lines = ladder.getLines();

        Map<Participant,Result> ladderResult = new HashMap<>();

        for (int order = 0; order < participants.size(); ++order) {
            Participant participant = participants.get(order);
            participant.initPosition(order);

            for (Line line : lines) {
                int position = participant.getPosition();

                if (position < lineWidth && line.hasBridge(position)) {
                    participant.moveRight();
                    continue;
                }
                if (position > 0 && line.hasBridge(position - 1)) {
                    participant.moveLeft();
                    continue;
                }
                participant.down();
            }
            int position = participant.getPosition();
            ladderResult.put(participant, results.getResults().get(position));

        }
        return new LadderResult(ladderResult);
    }
}
