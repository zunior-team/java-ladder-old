package ladder.domain;

import spark.utils.StringUtils;

import static ladder.constant.ParticipantConstants.PARTICIPANT_NAME_MAX_LENGTH;

public class Participant {

    private String name;
    private int widthIndex;
    private int heightIndex;

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
        this.heightIndex = y;
        this.widthIndex = 0;
    }
    public void moveRight(){
        this.heightIndex += 1;
        down();
    }
    public void moveLeft(){
        this.heightIndex -= 1;
        down();
    }
    public void down(){
        this.widthIndex += 1;
    }
    public int getPosition(){
        return this.heightIndex;
    }
    public boolean eqName(String name){
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
