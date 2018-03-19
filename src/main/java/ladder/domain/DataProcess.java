package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DataProcess {

	public static final int MAXNAMELEGTH = 5;
	public static final int RANDOMRANGE = 8;
	public static final int RANDOMMIN = 3;

	public static Boolean checkFlag(List<String> names) {
		return !checkNamesLength(names);
	}

	public static Boolean checkNamesLength(List<String> names) {
		int flag = 0;
		for (int i = 0; i < names.size(); i++) {
			flag = checkNamesLength(names, i, flag);
		}
		return flag <= 0;
	}

	public static int checkNamesLength(List<String> names, int i, int flag) {
		if (names.get(i).length() > MAXNAMELEGTH) {
			System.out.print("최대 5글자 까지만 입력가능합니다." + (i + 1) + "번째 이름 길이초과\n");
			flag++;
		}
		return flag;
	}

	public static String checkBranch(int i, int j, BranchLineManager branchLines) {
		if (branchLines.getPoint(i, j)) {
			return "-----";
		}
		return "     ";
	}

	public static Boolean getQuarter(int randNum) {
		if (randNum > RANDOMMIN) {
			return true;
		}
		return false;
	}

	public static int getUserArrivePosition(RewardManager rewardManager, String userName) {
		return rewardManager.getUserArrivePosition(rewardManager, userName);
	}

	public static RewardManager getUserArriveInfo(BranchLineManager branchLines, ArrayList<User> joinUser) {
		ResultManager resultManager = ResultManager.makeUserList(branchLines, joinUser);
		return resultManager.getRewardManager();
	}

	public static String getRewardName(RewardManager rewardManager, Reward reward, String userName) {
		int userResultPosition = DataProcess.getUserArrivePosition(rewardManager, userName);
		int resultPosition = rewardManager.getUserCol(userResultPosition);
		return reward.getReward(resultPosition);
	}

	public static String getResultName(RewardManager rewardManager, Reward reward, int i) {
		return reward.getReward(rewardManager.getUserCol(i));
	}

}