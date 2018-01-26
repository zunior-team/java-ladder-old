import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LineTest {
    Line line = new Line();

    @Before
    public void init(){
        line.addTrueFalse(true);
        line.addTrueFalse(true);
        line.addTrueFalse(false);
        line.addTrueFalse(true);
        line.addTrueFalse(true);
        line.addTrueFalse(false);
    }
    @Test
    public void sizePoints(){
        int result = line.sizeLine();
        assertEquals(6,result);
    }

    @Test
    public void setValueTest(){
        Boolean result = line.setValue(0);
        assertEquals(false, result);
    }

    @Test
    public void setValueTest2(){
        Boolean result = line.setValue(2);
        assertEquals(false, result);
    }

    @Test
    public void drawTest(){
        String result = line.result(0);
        assertEquals("-----", result);
    }

    @Test
    public void notDraw(){
        String result = line.result(2);
        assertEquals("     ", result);
    }
}
