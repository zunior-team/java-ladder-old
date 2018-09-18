
package study;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderTest {
    @Test
    public void append(){
        assertEquals("코드스쿼드 화이트 레벨 수강생은? 18 명이다.", createMessage(18));
    }

    private String createMessage(int numberOfClass){
        StringBuilder sb = new StringBuilder();
        sb.append("코드스쿼드 화이트 레벨 수강생은? ");
        sb.append(numberOfClass);
        sb.append(" 명이다.");
        return sb.toString();
    }
}
