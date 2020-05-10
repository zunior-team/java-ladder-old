package ladder.domain;

import spark.utils.StringUtils;

import java.util.*;
import java.util.function.Function;
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
        validateParticipants();
    }

    private void validateParticipants() {
        try {
            participants.stream()
                    .collect(Collectors.toMap(Participant::getName, Participant::getName))
                    .size();
        } catch (Exception e) {
            throw new IllegalArgumentException("중복되는 이름은 입력할 수 없습니다.");
        }
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
        if(RESULT_ALL.equals(name)){
            return null;
        }
        return participants.stream()
                .filter(participant -> participant.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
    public int participantsSize(){
        return participants.size();
    }
    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public String toString() {
        return participants.toString();
    }
}
