package ladder;

import java.util.ArrayList;

public class BranchLine {
	private ArrayList<Boolean> oneBranchSet;

	public BranchLine() {
		this.oneBranchSet = new ArrayList<>();
	}

	public void add(int j, Boolean branch) {
		oneBranchSet.add(check(branch, j));
	}

	public boolean check(Boolean branch, int j) {
		if (j != 0 && oneBranchSet.get(j - 1)) {
			return false;
		}
		return DataProcess.getRandomBoolean(Util.RAND.nextInt(DataProcess.RANDOMRANGE));
	}

	public boolean getPoint(int b) {
		return oneBranchSet.get(b);
	}

	public int getLength() {
		return oneBranchSet.size();
	}

}
