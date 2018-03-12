package ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintManager {
	Scanner sc = new Scanner(System.in);
	private int height;
	private int joinUser;
	private ArrayList<ArrayList<Branch>> branchArr;

	public int joinUser() {
		System.out.println("참여할 사람은 몇 명인가요");
		this.joinUser = sc.nextInt();
		return joinUser;
	}

	public int maxLadder() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		this.height = sc.nextInt();
		return height;
	}

	public void printLadder(ArrayList<ArrayList<Branch>> branchArr) {
		this.branchArr = branchArr;
		
		for (int i = 0; i < height; i++) {
			printLadder(i);
			System.out.print("|\n");
		}
	}

	public void printLadder(int i) {
		int col = 0;
		for (int j = 0; j < joinUser - 1; j++) {
			col = printBranch(i, j, col);
		}
	}

	public int printBranch(int i, int j, int col) {
		System.out.print("|");
		System.out.print(chkIsBranch(i, col, j));
		if (chkIsBranch(i, col, j) == "-") {
			col = colUp(col, i);
		}
		return col;
	}

	public String chkIsBranch(int i, int col, int j) {
		if (branchArr.get(i).size() != 0 && branchArr.get(i).get(col).getCol() == j) {
			return "-";
		}
		return " ";
	}

	public int colUp(int col, int i) {
		if (col < branchArr.get(i).size() - 1) {
			col++;
		}
		return col;
	}
}
