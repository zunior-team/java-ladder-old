package ladder.domain;

import java.util.ArrayList;

public class BranchLine {
	private ArrayList<Boolean> oneBranchSet;

	public BranchLine() {
		this.oneBranchSet = new ArrayList<>();
	}

	public void add(int j) {
		oneBranchSet.add(check(j, Util.RAND.nextInt(DataProcess.RANDOMRANGE)));
	}

	public void add(Boolean check) {
		oneBranchSet.add(check);
	}

	public boolean check(int j, int rand) {
		if (j != 0 && oneBranchSet.get(j - 1)) {
			return false;
		}
		return DataProcess.getQuarter(rand);
	}

	public boolean getPoint(int b) {
		return oneBranchSet.get(b);
	}

	public int getLength() {
		return oneBranchSet.size();
	}

}
