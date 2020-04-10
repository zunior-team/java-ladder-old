package ladder.domain;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.constant.ParticipantConstants.PARTICIPANT_NAME_SPLIT_TOKEN;

public class Participants {

    private List<Participant> participants;

    private Participants(String participantNames){
        validateParticipantNames(participantNames);
        this.participants = Arrays.stream(participantNames.split(PARTICIPANT_NAME_SPLIT_TOKEN))
                .map(Participant::of)
                .collect(Collectors.toList());
    }
    public static Participants of(String participantNames){
        return new Participants(participantNames);
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
