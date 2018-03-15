package ladder.domain;

import java.util.List;

import ladder.view.InputManager;
import ladder.view.PrintManager;

public class GameController {
	public static void gameStart() {
		printManager(InputManager.joinUser(), InputManager.maxLadder());
	}

	public static void printManager(List<String> joinUser, int maxLadder) {
		PrintManager printManager = new PrintManager();
		printManager.printUser(joinUser);
		printManager.printLadder(LadderManager.makeLadder(joinUser.size(), maxLadder));
	}
}
