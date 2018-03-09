package ladder;


import java.util.Scanner;

public class UserInput {
	Scanner sc = new Scanner(System.in);
	int joinUser() {
		System.out.println("참여할 사람은 몇 명인가요");
		return sc.nextInt();
	}
	int maxLadder() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return sc.nextInt();
	}
}
