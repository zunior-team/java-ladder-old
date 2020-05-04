package com.zuniorteam.ladder.core.util;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtil {

    private static final String EMPTY = "";

    private StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static String fill(Character token, int length) {
        return StringUtil.fill(EMPTY, token, length);
    }

    public static String fill(String base, Character token, int length) {
        return base + IntStream.range(base.length(), length)
                .mapToObj(i -> token.toString())
                .collect(Collectors.joining());
    }
}
