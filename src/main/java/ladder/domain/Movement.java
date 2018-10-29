package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Movement {
    private Random r = new Random();
    private ArrayList<Ladder> lineObject = new ArrayList<>();
    private static final int MAX = 5;

    public String[] nameCut(String inputName) {             //이름 객체에 잘라 넣기
        String[] cut = inputName.split(",");
        for (String s : cut) {
            nameException(s);
        }
        return cut;
    }

    private void nameException(String s) {
        if (s.length() > MAX) {
            throw new IllegalArgumentException("자리수가 잘못되었습니다. 다시 입력하세요.");
        }
    }

    public ArrayList<Ladder> ladderObject(int height, String inputName) {         //사다리 길이만큼 객체 생성
        for (int i = 0; i < height; i++) {
            lineObject.add(new Ladder(r.nextBoolean()));
            lineObject.get(i).randomInput(nameCut(inputName));
        }
        return lineObject;
    }
}