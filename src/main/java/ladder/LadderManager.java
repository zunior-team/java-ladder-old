package ladder;

import java.util.ArrayList;

public class LadderManager {

	public static ArrayList<BranchLine> makeLadder(int joinUser, int height) {
		ArrayList<BranchLine> BranchLineArr = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			BranchLineArr.add(addBranchLine(joinUser));
		}
		return BranchLineArr;
	}

	public static BranchLine addBranchLine(int joinUser) {
		BranchLine branchLine = new BranchLine();

		for (int j = 0; j < joinUser; j++) {
			branchLine.add(j, DataProcess.getRandomBoolean(Util.RAND.nextInt(DataProcess.RANDOMRANGE)));
		}
		return branchLine;
	}

}
