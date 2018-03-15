package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import ladder.domain.CheckData;

public class ImpormationLadder {

	static Scanner input = new Scanner(System.in);

	public static ArrayList<String> getNames() {
		System.out.println("참여할 사람이름을 적어주세요. (이름은 쉼표(,)로 구분하세요)");
		try {
			String inputName = input.nextLine();
			ArrayList<String> names = new ArrayList<>(Arrays.asList(inputName.split(",")));
			return CheckData.checkFinalNames(names);
		} catch (RuntimeException e) {
			return getNames();
		}
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
}
