package ladder;

import java.util.Random;

public class LadderRiding {
	private final int high;
	private final int name;

	public LadderRiding(int high, int name) { // 사다리 높이를 만든다.
		this.high = high;
		this.name = name;
	}

	public LadderLine[] ladderComplete() { // LadderLine 객체를 높이 만큼 만든다.
		LadderLine[] ladder = new LadderLine[high];
		for (int i = 0; i < high; i++) {
			ladder[i] = new LadderLine();
			ladder[i].creatLine(name);
		}
		return ladder;
	}
}