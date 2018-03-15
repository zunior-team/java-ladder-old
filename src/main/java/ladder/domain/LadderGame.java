package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderGame {

	private final int high;
	private ArrayList<String> names;

	public LadderGame(int high, ArrayList<String> names) { // 사다리 높이를 만든다.
		this.high = high;
		this.names = names;
	}

	public ArrayList<Line> ladderComplete() { // LadderLine 객체를 높이 만큼 만든다.
		ArrayList<Line> lines = new ArrayList<Line>();
		for (int i = 0; i < high; i++) {
			Line oneLine = new Line(names.size() - 1);
			lines.add(oneLine);
		}
		return lines;
	}
}
