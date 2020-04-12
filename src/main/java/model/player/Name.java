package model.player;

import exception.PlayersCreateException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final List<String> NONE_NAMES = Collections.singletonList("all");
    private String name;

    public Name(String name){
        validate(name);
        this.name = name;
    }

    private static void validate(String name){
        if(StringUtils.isEmpty(name)){
            throw new PlayersCreateException("이름은 널 또는 공백일 수 없습니다.");
        }

        if(name.length() >= MAXIMUM_NAME_LENGTH) {
            throw new PlayersCreateException("이름은 다섯글자를 넘을 수 없습니다.");
        }

        if(NONE_NAMES.contains(name)){
            throw new PlayersCreateException("이름에 `all` 은 생성할 수 없습니다.");
        }
    }

    public String get(){
        return name;
    }

    public int length(){
        return name.length();
    }
}
