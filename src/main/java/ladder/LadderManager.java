package ladder;

import java.util.ArrayList;
import java.util.Random;

public class LadderManager {

	private ArrayList<Branch> branch;
	private ArrayList<ArrayList<Branch>> branchArr;

	public LadderManager() {
		branch = new ArrayList<Branch>();
		branchArr = new ArrayList<ArrayList<Branch>>();
	}

	public void makeLadder(int joinUser, int height) {
		for (int i = 0; i < height; i++) {
			makeLadderCol(i, joinUser);
		}
	}

	public void makeLadderCol(int i, int joinUser) {
		for (int k = 0; k < joinUser - 1; k++) {
			makeBranch(i, k);
		}
	}

	public void makeBranch(int i, int k) {
		Random rand = new Random();
		int rn = rand.nextInt(10);
		if (rn < 5) {
			branch.add(new Branch(i, k));
		}
	}

	public void addMatchBranch(int height) {
		for (int b = 0; b < height; b++) {
			addCheckedBranch(chkMatchBranch(b, new ArrayList<Branch>()));
		}
	}

	public ArrayList<Branch> chkMatchBranch(int b, ArrayList<Branch> rowMatchedBranch) {
		for (int c = 0; c < branch.size(); c++) {
			chkRowMatchBranch(b, c, rowMatchedBranch);
		}
		return rowMatchedBranch;
	}

	public void chkRowMatchBranch(int b, int c, ArrayList<Branch> rowMatchedBranch) {
		if (branch.get(c).getRow() == b) {
			rowMatchedBranch.add(branch.get(c));
		}
	}

	public void addCheckedBranch(ArrayList<Branch> rowMatchedBranch) {
		if (rowMatchedBranch != null) {
			branchArr.add(rowMatchedBranch);
		}
	}

	public ArrayList<ArrayList<Branch>> sortLadder() {
		for (int i = 0; i < branchArr.size() - 1; i++) {
			sortLadder(i);
		}
		return branchArr;
	}

	public void sortLadder(int i) {
		for (int j = 0; j < branchArr.get(i).size() - 1; j++) {
			sortLadder(i, j);
		}
	}

	public void sortLadder(int i, int j) {
		Branch temp = new Branch(0, 0);
		if (branchArr.get(i).get(j).getCol() > branchArr.get(i).get(j + 1).getCol()) {
			temp = branchArr.get(i).get(j);
			branchArr.get(i).set(i, branchArr.get(i).get(j + 1));
			branchArr.get(i).set(i + 1, temp);
		}
	}

}
