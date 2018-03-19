package ladder.domain;

import java.util.ArrayList;

public class RewardManager {
	private ArrayList<User> rewardManager;

	public RewardManager(ArrayList<User> rewardManager) {
		this.rewardManager = rewardManager;
	}

	public ArrayList<User> getRewardManager() {
		return rewardManager;
	}

	public int size() {
		return rewardManager.size();
	}

	public void userMoveRight(int j) {
		rewardManager.get(j).increaseCol();
	}

	public void userMoveLeft(int j) {
		rewardManager.get(j).decreaseCol();
	}

	public User getUser(int i) {
		return rewardManager.get(i);
	}

	public int getUserCol(int i) {
		return rewardManager.get(i).getCol();
	}

	public void setUser(int i, User user) {
		rewardManager.set(i, user);
	}

	public String getUserName(int i) {
		return rewardManager.get(i).getName();
	}

	public boolean isSameName(int i, String userName) {
		return rewardManager.get(i).isSameName(userName);
	}

	public int getUserArrivePosition(RewardManager rewardManager, String userName) {
		int position = 0;
		for (int i = 0; i < rewardManager.size(); i++) {
			if (rewardManager.isSameName(i, userName)) {
				return i;
			}
		}
		return position;
	}

}
