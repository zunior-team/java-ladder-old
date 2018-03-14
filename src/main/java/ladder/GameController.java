package ladder;

import java.util.List;

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
