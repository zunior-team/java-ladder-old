package ladder.view;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.BranchLine;
import ladder.domain.DataProcess;

public class PrintManager {

	ArrayList<BranchLine> branchLines;

	public void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i) + "     ");
		}
		System.out.print("\n");
	}

	public void printLadder(ArrayList<BranchLine> branchArr) {
		this.branchLines = branchArr;
		for (int i = 0; i < branchArr.size(); i++) {
			System.out.print("|");
			printLadder(i);
			System.out.print("\n");
		}
	}

	public void printLadder(int i) {
		for (int j = 0; j < branchLines.get(i).getLength() - 1; j++) {
			System.out.print(DataProcess.checkBranch(i, j, branchLines));
			System.out.print("|");
		}
	}

}
