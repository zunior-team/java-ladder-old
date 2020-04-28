package ladder.domain;

import spark.utils.StringUtils;

public class Result {

    private String name;

    public Result(String name){
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("결과명은 비어있을수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
