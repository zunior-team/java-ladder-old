package ladder.domain;

import java.util.ArrayList;

public class BranchLineManager {
	private ArrayList<BranchLine> branchLineManager;

	public BranchLineManager(ArrayList<BranchLine> branchLineManager) {
		this.branchLineManager = branchLineManager;
	}

	public int size() {
		return branchLineManager.size();
	}

	public int getLength(int i) {
		return branchLineManager.get(i).getLength();
	}

	public boolean getPoint(int i, int j) {
		return branchLineManager.get(i).getPoint(j);
	}
	
	public ArrayList<BranchLine> getBranchLineManager(){
		return branchLineManager;
	}

}
