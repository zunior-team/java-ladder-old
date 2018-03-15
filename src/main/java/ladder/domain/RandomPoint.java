package ladder.domain;

import java.util.Random;

public class RandomPoint {
	
	public static boolean make(boolean coin) { // true or false 값을 만들어 반환한다.
		if(coin) {
			return true;
		}
		return false;
	}
}
