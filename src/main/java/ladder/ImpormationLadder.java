package ladder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImpormationLadder {
	public static int getManNum() {
		int manNum = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("참여할 사람은 몇 명인가요?");
		try {
			manNum = input.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("정수만 입력해주세요");
		}
		return manNum;
	}

	public static int getLadderNum() {
		int ladderNum = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("최대 사다리 높이는 몇 개인가?");
		try {
			ladderNum = input.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("정수만 입력해주세요");
		}
		return ladderNum;
	}
}
