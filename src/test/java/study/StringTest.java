package study;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "박재성";
        assertThat(name.length()).isEqualTo(3);
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "박재성";
        String welcome = "안녕!";
        assertThat(welcome+name).isEqualTo("안녕!박재성");
    }

    @Test
    public void 문자열을_문자_단위로_출력() {
        String name = "박재성";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    }

    @Test
    public void 문자열_뒤집기() {
        String name = "박재성";
        int j = name.length() - 1;
        char[] tmp = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            tmp[i] = name.charAt(j);
            j--;
        }
        String reverseName = String.valueOf(tmp);

        assertThat(reverseName).isEqualTo("성재박");
    }

    @Test
    public void append() {
        assertThat(StringStudy.createMessage(14)).isEqualTo("코드스쿼드 백엔드 수강생은? 14 명이다.");
    }
}
