package com.zuniorteam.ladder.core.util;

import java.util.List;

public class CollectionUtils {

    private static final int FIRST_INDEX = 0;

    private CollectionUtils(){}

    public static boolean isFirstIndex(int index){
        return index == FIRST_INDEX;
    }

    public static  <T> T getBefore(List<T> collections, int index) {
        if(index <= FIRST_INDEX){
            throw new IllegalArgumentException(FIRST_INDEX + " 이전 값을 가져올 수 없습니다.");
        }

        return collections.get(index - 1);
    }
}
