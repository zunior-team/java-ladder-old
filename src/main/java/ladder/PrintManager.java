package ladder;

import java.util.ArrayList;
import java.util.List;

public class PrintManager {

	ArrayList<BranchLine> branchArr;

	public void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			Util.print(joinUser.get(i) + "     ");
		}
		Util.print("\n");
	}

	public void printLadder(ArrayList<BranchLine> branchArr) {
		this.branchArr = branchArr;
		for (int i = 0; i < branchArr.size(); i++) {
			Util.print("|");
			printLadder(i);
			Util.print("\n");
		}
	}

	public void printLadder(int i) {
		for (int j = 0; j < branchArr.get(i).getLength() - 1; j++) {
			Util.print(DataProcess.checkBranch(i, j, branchArr));
			Util.print("|");
		}
	}

}
