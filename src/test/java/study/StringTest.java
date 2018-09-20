package study;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {
    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "노진산";
        assertEquals(3, name.length());
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "노진산";
        String welcome = "안녕!";
        assertEquals("안녕!노진산", welcome + name);
    }

    @Test
    public void 문자열을_문자_단위로_출력() throws Exception {
        String name = "노진산";
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
    }
}
