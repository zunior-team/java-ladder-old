package ladder.domain;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.constant.ParticipantConstants.INPUT_SPLIT_TOKEN;
import static ladder.constant.ParticipantConstants.RESULT_ALL;

public class Participants {

    private List<Participant> participants;

    private Participants(String participantNames){
        validateParticipantNames(participantNames);
        this.participants = Arrays.stream(participantNames.split(INPUT_SPLIT_TOKEN))
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

    public Participant getParticipantByName(String name){
        if(name.equals(RESULT_ALL)){
            return null;
        }
        return participants.stream()
                .filter(participant -> participant.toString().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public String toString() {
        return participants.toString();
    }
}
