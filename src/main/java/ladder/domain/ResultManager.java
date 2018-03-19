package ladder.domain;

import java.util.ArrayList;

public class ResultManager {

	private BranchLineManager branchLineManager;
	private RewardManager rewardManager;

	public ResultManager(BranchLineManager branchLineManager, RewardManager rewardManager) {
		this.rewardManager = rewardManager;
		this.branchLineManager = branchLineManager;
	}

	public static ResultManager makeUserList(BranchLineManager branchLineManager, ArrayList<User> joinUser) {
		RewardManager rewardManager = new RewardManager(joinUser);
		return new ResultManager(branchLineManager, rewardManager);
	}

	public RewardManager getRewardManager() {
		for (int i = 0; i < branchLineManager.size(); i++) {
			getRewardManager(i);
			sortRewardManager();
		}
		return rewardManager;
	}

	public void getRewardManager(int i) {
		for (int j = 0; j < rewardManager.size(); j++) {
			updateColProcess(i, j);
		}
	}

	public void updateColProcess(int i, int j) {
		if (j != rewardManager.size() - 1 && branchLineManager.getPoint(i, j)) {
			rewardManager.userMoveRight(j);
			return;
		}
		if (j != 0 && branchLineManager.getPoint(i, j - 1)) {
			rewardManager.userMoveLeft(j);
		}
	}

	public void sortRewardManager() {
		for (int i = 0; i < rewardManager.size() - 1; i++) {
			sortRewardManager(i);
		}
	}

	public void sortRewardManager(int i) {

		if (rewardManager.getUserCol(i) > rewardManager.getUserCol(i + 1)) {
			User tempUser = rewardManager.getUser(i);
			rewardManager.setUser(i, rewardManager.getUser(i + 1));
			rewardManager.setUser(i + 1, tempUser);
		}

	}

}
