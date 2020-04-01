package ladder.domain;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.constant.ParticipantConstants.COMMA;

public class Participants {

    private List<Participant> participants;

    private Participants(List<Participant> participants){
        this.participants = participants;
    }
    public static Participants of(String participantNames){
        validateParticipantNames(participantNames);

        List<Participant> participants = Arrays.stream(participantNames.split(COMMA))
                .map(Participant::of)
                .collect(Collectors.toList());

        return new Participants(participants);
    }
    private static void validateParticipantNames(String participantNames){
        if(StringUtils.isEmpty(participantNames)){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public String toString() {
        return participants.toString();
    }
}
