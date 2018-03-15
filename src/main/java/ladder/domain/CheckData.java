package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

import ladder.view.ImpormationLadder;

public class CheckData {

	public static boolean checkName(ArrayList<String> names) {// 이름이 5자가 넘는지 체크
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() > 5) {
				System.out.println("이름은 5자까지 입력 가능합니다.");
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> checkFinalNames(ArrayList<String> names) {// 이름이 5자가 넘어가면 예외 발생.
		if (!checkName(names)) {
			throw new RuntimeException();
		}
		return names;
	}
}