package com.zuniorteam.ladder.core.util;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class CollectionUtils {

    private static final int FIRST_INDEX = 0;

    private CollectionUtils() {
    }

    public static boolean isFirstIndex(int index) {
        return index == FIRST_INDEX;
    }

    public static <T> T getBefore(List<T> collection, int index) {
        if (index <= FIRST_INDEX) {
            throw new IllegalArgumentException(FIRST_INDEX + " 이전 값을 가져올 수 없습니다.");
        }

        return collection.get(index - 1);
    }

    public static <T,V> List<V> simpleMap(List<T> collection, Function<? super T, ? extends V> mapper){
        return collection.stream()
                .map(mapper)
                .collect(toList());
    }

}
