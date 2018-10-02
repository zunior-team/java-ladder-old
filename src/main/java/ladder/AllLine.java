package ladder;

import java.util.*;

public class AllLine {
    private ArrayList<Line> allLine = new ArrayList<>();
    private ArrayList<String> valueMatchName = new ArrayList<>();

    public AllLine(int countOfPerson, int height) {
        for (int i = 0; i < height; i++)
            allLine.add(new Line(countOfPerson));
    }

    public void ladderPrint() {
        PrintView.ladderPrint(allLine);
    }

    public void gameStart(String[] resultValue) {
        for (int startPosition = 0; startPosition < resultValue.length; startPosition++) {
            valueMatchName.add(resultValue[ladderResult(startPosition)]);           // 예를들어, 결과값 배열에서 첫번째 이름에 해당하는 값을 가장 먼저 넣어주고
        }
    }

    private int ladderResult(int startPosition) {
        int currentPosition = startPosition;
        for (int i = 0; i < allLine.size(); i++)
            currentPosition = allLine.get(i).move(currentPosition);
        return currentPosition;
    }

    public Map<String, String> matchName(String[] names) {
        Map<String, String> NameAndValue = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            NameAndValue.put(names[i], valueMatchName.get(i));
        }
        return NameAndValue;
    }
}

