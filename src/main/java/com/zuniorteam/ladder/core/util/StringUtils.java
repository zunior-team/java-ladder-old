package com.zuniorteam.ladder.core.util;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static String fillRest(String base, char token, int length) {
        return base + IntStream.range(base.length(), length)
                .mapToObj(i -> token)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
