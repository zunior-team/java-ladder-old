import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ladder.domain.CheckData;
import ladder.domain.Line;
import ladder.domain.ResultLine;
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

	@Test
	public void resultLineTest() {
		Line line = new Line(false); // Boolean 값이 false인 사다리를 만든다
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi"));
		ResultLine result = new ResultLine(line, test);
		// false이므로 river pobi가 그대로여야한다.
		assertEquals(test, result.getResultLine());
	}

	@Test
	public void resultLinefalseTest() {
		Line line = new Line(true); // Boolean 값이 true인 사다리를 만든다
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi"));
		ArrayList<String> test2 = new ArrayList<String>(Arrays.asList("pobi", "river"));
		ResultLine result = new ResultLine(line, test);
		assertEquals(test2, result.getResultLine()); // true이므로 자리가 바뀌어야 한다.
	}

	@Test
	public void getLocationTest() {
		Line line = new Line(false);
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi"));
		ResultLine result = new ResultLine(line, test);

		assertEquals(0, result.getLocation(0, line)); // point가 false이고 i=0이므로 그대로
	}

	@Test
	public void getLocationTest2() {
		Line line = new Line(true);
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("river", "pobi"));
		ResultLine result = new ResultLine(line, test);

		assertEquals(1, result.getLocation(0, line)); // point가 true이고 i=0이므로 i+1
	}

}
