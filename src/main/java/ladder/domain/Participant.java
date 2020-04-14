package ladder.domain;

import spark.utils.StringUtils;

import static ladder.constant.ParticipantConstants.PARTICIPANT_NAME_MAX_LENGTH;

public class Participant {

    private String name;
    private int x;
    private int y;

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
    public void initPosition(int y){
        this.y = y;
        this.x = 0;
    }
    public void moveRight(){
        this.y += 1;
        down();
    }
    public void moveLeft(){
        this.y -= 1;
        down();
    }
    public void down(){
        this.x += 1;
    }
    public int getPosition(){
        return this.y;
    }

    @Override
    public String toString() {
        return name;
    }
}
