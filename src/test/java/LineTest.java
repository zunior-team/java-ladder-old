import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ladder.domain.CheckData;
import ladder.domain.Line;
import ladder.view.ImpormationLadder;
import ladder.view.PrintLadder;

public class LineTest {

	@Test
	public void checkLineZeroTest() {
		Line test = new Line(0);
		
		assertEquals(false, test.checkLine(0, false));
	}

	@Test
	public void checkLineBeforeindexTrueTest() {
		// 전 인덱스에 사다리가 있으면 false가 나와야한다.
		Line test2 = new Line(true);
		
		assertEquals(false, test2.checkLine(1, true));
	}

	@Test
	public void isTruePrintTrueTest() { // 출력값 확인
		PrintLadder test = new PrintLadder();
		Line line = new Line(5);

		assertEquals("-----", test.isTruePrint(true));
	}

	public void isTruePrintFalseTest() { // 출력값 확인
		PrintLadder test = new PrintLadder();
		Line line = new Line(5);

		assertEquals("     ", test.isTruePrint(false));
	}

	@Test
	public void checkNameTest() { // 5글자가 넘으면 false 넘지 않으면 true를 반환하는 메소드
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi", "way", "code"));

		assertEquals(true, CheckData.checkName(test));
	}

	@Test
	public void checkNameOverTest() { // 5글자가 넘으면 false 넘지 않으면 true를 반환하는 메소드
		ArrayList<String> test2 = new ArrayList<String>(Arrays.asList("riverway", "jun", "stop", "rise"));

		assertEquals(false, CheckData.checkName(test2));
	}

	@Test
	public void checkFinalNamesTest() {
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi", "way", "code"));

		assertEquals(test, CheckData.checkFinalNames(test));
	}

	@Test(expected = RuntimeException.class) // 예외 테스트
	public void checkFinalNamesExceptionTest() {
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("riverway", "junho", "stop", "rise"));

		CheckData.checkFinalNames(test);
	}
}
