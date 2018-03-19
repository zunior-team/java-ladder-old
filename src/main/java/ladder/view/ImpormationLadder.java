package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import ladder.domain.CheckData;

public class ImpormationLadder {

	static Scanner input = new Scanner(System.in);

	public static List<String> getNames() {
		System.out.println("참여할 사람이름을 적어주세요. (이름은 쉼표(,)로 구분하세요)");
		try {
			String inputName = input.nextLine();
			List<String> names = new ArrayList<>(Arrays.asList(inputName.split(",")));
			return CheckData.checkFinalNames(names);
		} catch (RuntimeException e) {
			return getNames();
		}
	}

	public static List<String> getResult() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		String inputResult = input.nextLine();
		List<String> results = new ArrayList<>(Arrays.asList(inputResult.split(",")));
		return results;
	}

	public static int getLadderNum() {
		System.out.println("최대 사다리 높이는 몇 개인가?");
		try {
			int ladderNum = input.nextInt();
			return ladderNum;
		} catch (InputMismatchException ime) {
			System.out.println("정수만 입력해주세요");
			return getLadderNum();
		}
	}

	public static String getLadderResult() {
		Scanner in = new Scanner(System.in);
		System.out.println("결과를 보고 싶은 사람은?");
		String inputName = in.nextLine();
		return inputName;
	}
}
