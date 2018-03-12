package ladder;

import java.util.Random;

public class LadderRiding {
	private final int high;
	private final int name;

	public LadderRiding(int high, int name) { // 사다리 높이를 만든다.
		this.high = high;
		this.name = name;
	}

	public boolean makeRandom() { // true or false 값을 만들어 반환한다.
		Random ran = new Random();
		boolean line = ran.nextBoolean();
		return line;
	}

	public void makeOneLine(boolean[][] ladder, int oneline) { // 사다리 한줄을 만든다.
		for (int j = 0; j < ladder[oneline].length; j++) {
			ladder[oneline][j] = makeRandom();
		}
	}

	public boolean[][] makeAllLadder(int high, int name) { // 사다리 전체를 만든다.
		boolean[][] ladder = new boolean[high][name - 1];
		for (int i = 0; i < ladder.length; i++) {
			makeOneLine(ladder, i);
		}
		return ladder;
	}
}