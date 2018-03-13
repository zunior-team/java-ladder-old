package ladder;

import java.util.ArrayList;

public class Line {

	private ArrayList<Boolean> points = new ArrayList<>();

	public Line(int lineSize) {
		creatLine(lineSize);
	}

	public void creatLine(int lineSize) { // 사다리 한줄을 만든다.
		RandomLine rl = new RandomLine();
		for (int i = 0; i < lineSize; i++) {
			checkLine(i, rl);
		}
	}

	public void checkLine(int nowPoint, RandomLine rl) { // 전 인덱스의"-----" 유무를 확인하고 만들지 말지 결정한다.
		if (nowPoint == 0) {
			points.add(rl.makeRandom());
			return;
		} else if (nowPoint >= 1 && (points.get(nowPoint - 1) == false)) { // 인덱스가 1이상이고 전 인덱스가 false일때.
			points.add(rl.makeRandom());
			return;
		}
		points.add(false);
	}

	public ArrayList<Boolean> getLine() {
		return this.points;
	}
}
