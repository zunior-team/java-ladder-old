package com.zuniorteam.ladder.core.util;

public final class MathUtil {

    private MathUtil() {
    }

    public static double divide(int x, int y){
        if(y == 0){
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다");
        }

        return ((double) x) / y;
    }
}
