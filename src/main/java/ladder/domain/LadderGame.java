package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {

	private final int high;
	private List<String> names;

	public LadderGame(int high, List<String> names) { // 사다리 높이를 만든다.
		this.high = high;
		this.names = names;
	}

	public List<Line> ladderComplete() { // LadderLine 객체를 높이 만큼 만든다.
		List<Line> lines = new ArrayList<Line>();

		for (int i = 0; i < high; i++) {
			Line oneLine = new Line(names.size() - 1);
			lines.add(oneLine);
		}
		return lines;
	}

	public List<String> createResult(List<Line> lines) { // Line의 결과를 구하고 마지막 줄의 결과를 반환.
		List<String> beforeLine;
		ResultLine currentLine = new ResultLine(lines.get(0), names);

		for (int i = 1; i < lines.size(); i++) {
			beforeLine = currentLine.getResultLine();
			currentLine = new ResultLine(lines.get(i), beforeLine);
		}
		return currentLine.getResultLine();
	}

	public int resultOneMan(List<Line> lines, String inputName) { // 한명의 결과를 구하기 위한 메소드
		int beforeIndex = names.indexOf(inputName); // 입력한 이름의 인덱스를 찾아서 넣어준다.

		for (int i = 0; i < lines.size(); i++) {
			beforeIndex = ResultLine.getLocation(beforeIndex, lines.get(i));
		}
		return beforeIndex;
	}
}
