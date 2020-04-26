package com.zuniorteam.ladder.core.util;

import java.util.HashSet;
import java.util.List;

public final class CollectionUtils {

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

    public static boolean isUnique(List<String> collection) {
        return new HashSet<>(collection).size() == collection.size();
    }
}
