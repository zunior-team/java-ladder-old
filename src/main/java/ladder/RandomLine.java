package ladder;

import java.util.Random;

public class RandomLine {

	public boolean makeRandom() { // true or false 값을 만들어 반환한다.
		Random ran = new Random();
		boolean line = ran.nextBoolean();
		return line;
	}
}
