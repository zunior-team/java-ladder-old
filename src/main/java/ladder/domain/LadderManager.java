package ladder.domain;

import java.util.ArrayList;

public class LadderManager {

	public static ArrayList<BranchLine> makeLadder(int joinUser, int height) {
		ArrayList<BranchLine> branchLines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			branchLines.add(addBranchLine(joinUser));
		}
		return branchLines;
	}

	public static BranchLine addBranchLine(int joinUser) {
		BranchLine branchLine = new BranchLine();

		for (int j = 0; j < joinUser; j++) {
			branchLine.add(j);
		}
		return branchLine;
	}

}
