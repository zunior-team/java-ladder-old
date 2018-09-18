package study;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrintTest {
    @Test
    public void print(){
        System.out.println(String.format("%5s%5s", "aaaa", "bbbb"));
        String a = String.format("%5s", "cccxcccccc");
        System.out.println(a);

    }

}
