package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ResultLine {

	private List<String> oneLineResult;
	private int size;

	public ResultLine(Line line, List<String> beforeNames) {
		this.size = beforeNames.size();
		this.oneLineResult = resultLine(beforeNames, line);
	}

	// 사다리 한줄을 타고 난 후 위치를 저장
	public ArrayList<String> resultLine(List<String> beforeNames, Line line) {
		String[] resultNames = new String[size];
		for (int i = 0; i < size; i++) {
			resultNames[getLocation(i, line)] = beforeNames.get(i);
		}
		return new ArrayList<>(Arrays.asList(resultNames));
	}

	// 전줄의 이름을 참고해 현재 줄의 어느 위치로 갈지 반환
	public static int getLocation(int i, Line line) {
		if (i != 0 && line.move(i - 1)) {
			return i - 1;
		} else if (i != (line.getLine().size()) && line.move(i)) {
			return i + 1;
		}
		return i;
	}

	public List<String> getResultLine() {
		return oneLineResult;
	}

}
