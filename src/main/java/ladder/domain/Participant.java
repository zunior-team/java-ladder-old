package ladder.domain;

import spark.utils.StringUtils;

import static ladder.constant.ParticipantConstants.PARTICIPANT_NAME_MAX_LENGTH;

public class Participant {

    private String name;

    private Participant(String name){
        validateName(name);
        this.name = name;
    }
    public static Participant of(String name){
        return new Participant(name);
    }
    private static void validateName(String name){
        if(StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        if(name.length() > PARTICIPANT_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
