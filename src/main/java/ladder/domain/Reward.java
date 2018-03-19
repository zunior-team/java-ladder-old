package ladder.domain;

import java.util.List;

public class Reward {
	List<String> rewardList;

	public Reward(List<String> rewardList) {
		this.rewardList = rewardList;
	}

	public static Reward of(List<String> rewardList) {
		return new Reward(rewardList);
	}

	public List<String> getRewardList() {
		return rewardList;
	}

	public int getRewardListSize() {
		return rewardList.size();
	}

	public String getReward(int i) {
		return rewardList.get(i);
	}

}
