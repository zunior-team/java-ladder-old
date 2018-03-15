package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
	static Random ran = new Random();

	private ArrayList<Boolean> points = new ArrayList<>();

	public Line(int lineSize) {
		creatLine(lineSize);
	}
	
	public Line(boolean test) {           //테스트를 위한 생성자
		creatLine(0);
		points.add(test);
	}

	public void creatLine(int lineSize) {    // 사다리 한줄을 만든다.
		for (int i = 0; i < lineSize; i++) {
			points.add(checkLine(i, ran.nextBoolean()));
		}
	}

	public boolean checkLine(int nowPoint, boolean rand) { // 전 인덱스의"-----" 유무를 확인하고 만들지 말지 결정한다.
		if (nowPoint == 0) {
			return RandomPoint.make(rand);
		}
		else if (points.get(nowPoint - 1) == false){ 
			return advantageRule(rand);
		}
		return false;								 	//전 인덱스가 true일때.
	}
	// 전 인덱스의 값이 true면 현재 인덱스의 값이 false가되므로 사다리가 줄어든다.
	// 사다리 줄을 늘리기 위해서 전 인덱스가 false 였으면 랜덤값을 한번 더 돌린다.
	public boolean advantageRule(boolean newRandom) { 
		if (newRandom == false) { 					
			return RandomPoint.make(ran.nextBoolean());
		}
		return newRandom;
	}

	public ArrayList<Boolean> getLine() {
		return this.points;
	}
}
