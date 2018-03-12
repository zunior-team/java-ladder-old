package ladder;

public class LadderLine {
	private boolean[] line;

	public void creatLine(int oneline) { // 사다리 한줄을 만든다.
		RandomLine rl = new RandomLine();
		line = new boolean[oneline];
		for (int i = 0; i < oneline; i++) {
			line[i] = rl.makeRandom();
		}
	}

	public boolean[] getLine() {
		return this.line;
	}
}
