package model.player;

import exception.PlayersCreateException;
import org.apache.commons.lang3.StringUtils;

public class Player {

    private static final int MAXIMUM_NAME_LENTH = 5;
    private Name name;

    private Player(String name){
        this.name = new Name(name);
    }

    public static Player create(final String name){
        validate(name);
        return new Player(name);
    }

    private static void validate(String name){
        if(StringUtils.isEmpty(name)){
            throw new PlayersCreateException("이름은 널 또는 공백일 수 없습니다.");
        }

        if(name.length() >= MAXIMUM_NAME_LENTH) {
            throw new PlayersCreateException("이름은 다섯글자를 넘을 수 없습니다.");
        }
    }
}
