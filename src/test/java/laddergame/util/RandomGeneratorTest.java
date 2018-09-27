package laddergame.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomGeneratorTest {

    @Test
    public void makeRandNum() {
        int n = 3;
        assertEquals(Boolean.TRUE, makeRandNumTest(n, RandomGenerator.makeRandNum(n)));
    }

    public Boolean makeRandNumTest(int n, int i) {
        return (0 <= i && i < n);
    }

}