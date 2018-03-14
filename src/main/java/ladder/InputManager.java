package ladder;

import java.util.Arrays;
import java.util.List;

public class InputManager {

	public static List<String> joinUser() {
		List<String> names = null;
		Boolean flag = true;

		while (flag) {
			System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
			names = Arrays.asList(Util.sc.nextLine().split(","));
			flag = DataProcess.checkFlag(names);
		}
		return names;
	}

	public static int maxLadder() {
		Util.print("\n최대 사다리 높이는 몇 개인가요?");
		return Util.sc.nextInt();
	}
}
