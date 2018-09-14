package ladder;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView(InputStream inputStream) {
        sc = new Scanner(inputStream);
    }

    public int getPeopleNumber(){
        System.out.println("참여할 사람은 몇 명 인가요?");
        return sc.nextInt();
    }

    public int getLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
