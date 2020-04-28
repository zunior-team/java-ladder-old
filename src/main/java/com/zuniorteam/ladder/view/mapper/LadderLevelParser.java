package com.zuniorteam.ladder.view.mapper;

import com.zuniorteam.ladder.core.LadderLevel;
import com.zuniorteam.ladder.core.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.zuniorteam.ladder.core.LadderLevel.*;


public final class LadderLevelParser {

    private LadderLevelParser(){
    }

    private static final Map<String, LadderLevel> KEYWORD_TO_LADDER_LEVEL = new HashMap<>();

    static {
        KEYWORD_TO_LADDER_LEVEL.put("상", HIGH);
        KEYWORD_TO_LADDER_LEVEL.put("중", MEDIUM);
        KEYWORD_TO_LADDER_LEVEL.put("하", LOW);
    }

    public static LadderLevel parse(String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            throw new IllegalArgumentException("사다리 난이도를 입력해주세요");
        }

        if (!KEYWORD_TO_LADDER_LEVEL.containsKey(keyword)) {
            throw new IllegalArgumentException("알 수 없는 사다리 레벨 입니다 : " + keyword);
        }

        return KEYWORD_TO_LADDER_LEVEL.get(keyword);
    }

}
