package ladder.view;

import java.util.Scanner;

public class InputView {
    Scanner s = new Scanner(System.in);
    public int userInput(){
        System.out.println("참여할 사람은 몇 명 인가요?");
        int input;
        return input = s.nextInt();
    }

    public int heightInput(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int Input = 0;
        return Input = s.nextInt();
    }
}
