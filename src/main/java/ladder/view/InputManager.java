package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ladder.domain.DataProcess;
import ladder.domain.User;
import ladder.domain.Util;

public class InputManager {

	public static ArrayList<User> joinUser() {
		List<String> names = null;
		ArrayList<User> joinUser = new ArrayList<>();
		Boolean flag = true;
		while (flag) {
			System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
			names = Arrays.asList(Util.sc.nextLine().split(","));
			flag = DataProcess.checkFlag(names);
		}

		for (int i = 0; i < names.size(); i++) {
			joinUser.add(new User(i, names.get(i)));
		}

		return joinUser;
	}

	public static List<String> result() {
		List<String> result = null;
		Boolean flag = true;

		while (flag) {
			System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
			result = Arrays.asList(Util.sc.nextLine().split(","));
			flag = DataProcess.checkFlag(result);
		}
		return result;
	}

	public static int maxLadder() {
		System.out.print("\n최대 사다리 높이는 몇 개인가요?");
		return Util.sc.nextInt();
	}

	public static String printQuestion() {
		System.out.print("\n결과를 보고 싶은 사람은?");
		return Util.sc.next();
	}

}
