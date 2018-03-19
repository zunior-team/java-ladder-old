package ladder.view;

import java.util.List;

import ladder.domain.BranchLineManager;
import ladder.domain.DataProcess;
import ladder.domain.Reward;
import ladder.domain.RewardManager;
import ladder.domain.User;

public class PrintManager {

	public static void printUser(List<User> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i).getName() + "     ");
		}
		System.out.print("\n");
	}

	public static void printLadder(BranchLineManager branchLines) {
		for (int i = 0; i < branchLines.size(); i++) {
			System.out.print("|");
			printLadder(branchLines, i);
			System.out.print("\n");
		}
	}

	public static void printLadder(BranchLineManager branchLines, int i) {
		for (int j = 0; j < branchLines.getLength(i) - 1; j++) {
			System.out.print(DataProcess.checkBranch(i, j, branchLines));
			System.out.print("|");
		}
	}

	public static void printResult(Reward reward) {
		for (int i = 0; i < reward.getRewardListSize(); i++) {
			System.out.print(reward.getReward(i) + "     ");
		}
		System.out.print("\n");
	}

	public static void printFinalResult(String resultUserName, String resultName) {
		System.out.println("실행결과는");
		System.out.println(resultUserName + " : " + resultName);
	}

	public static void printFinalResult(RewardManager rewardManager, Reward reward) {
		System.out.println("실행결과는");
		for (int i = 0; i < rewardManager.size(); i++) {
			System.out.println(
					rewardManager.getUserName(i) + " : " + DataProcess.getResultName(rewardManager, reward, i));
		}
	}
}
