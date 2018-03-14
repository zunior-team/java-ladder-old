package ladder;

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
			Util.print("최대 5글자 까지만 입력가능합니다." + (i + 1) + "번째 이름 길이초과\n");
			flag++;
		}
		return flag;
	}

	public static String checkBranch(int i, int j, ArrayList<BranchLine> branchArr) {
		if (branchArr.get(i).getPoint(j)) {
			return "-----";
		}
		return "     ";
	}

	public static Boolean getRandomBoolean(int randNum) {
		if (randNum > RANDOMMIN) {
			return true;
		}
		return false;
	}

}
