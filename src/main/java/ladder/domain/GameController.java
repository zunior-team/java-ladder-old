package ladder.domain;

import java.util.ArrayList;

import ladder.view.InputManager;
import ladder.view.PrintManager;

public class GameController {
	public static void startGame() {
		ArrayList<User> joinUser = InputManager.joinUser();
		Reward reward = Reward.of(InputManager.result());

		BranchLineManager branchLineManager = new BranchLineManager(
				LadderManager.makeLadder(joinUser.size(), InputManager.maxLadder()));

		startPrintProcess(joinUser, reward, branchLineManager);
		startResultProcess(DataProcess.getUserArriveInfo(branchLineManager, joinUser), reward, joinUser);
	}

	public static void startPrintProcess(ArrayList<User> joinUser, Reward reward, BranchLineManager branchLines) {
		PrintManager.printUser(joinUser);
		PrintManager.printLadder(branchLines);
		PrintManager.printResult(reward);
	}

	public static void startResultProcess(RewardManager rewardManager, Reward reward, ArrayList<User> joinUser) {
		String resultUserName = InputManager.printQuestion();
		if (resultUserName.equals("all")) {
			PrintManager.printFinalResult(rewardManager, reward);
			return;
		}
		
		String rewardName = DataProcess.getRewardName(rewardManager, reward, resultUserName);
		System.out.println(rewardName);
		PrintManager.printFinalResult(resultUserName, rewardName);
	}

}
